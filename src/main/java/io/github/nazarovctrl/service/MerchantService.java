package io.github.nazarovctrl.service;

import io.github.nazarovctrl.config.BillingDetail;
import io.github.nazarovctrl.dto.db.Order;
import io.github.nazarovctrl.dto.db.Transaction;
import io.github.nazarovctrl.dto.reqeust.*;
import io.github.nazarovctrl.dto.result.*;
import io.github.nazarovctrl.enums.Method;
import io.github.nazarovctrl.enums.OrderCancelReason;
import io.github.nazarovctrl.enums.TransactionState;
import io.github.nazarovctrl.exp.*;
import io.github.nazarovctrl.mapper.MerchantMapper;
import io.github.nazarovctrl.repository.IMerchantRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Class for processing RPC requests
 *
 * @author Azimjon Nazarov
 */
@Service
public class MerchantService {
    private static final Long time_expired = 43_200_000L;
    private final BillingDetail billingDetail;
    private final IMerchantRepository merchantRepository;
    private final IPaymentService paymentService;

    public MerchantService(BillingDetail billingDetail, IMerchantRepository merchantRepository, IPaymentService paymentService) {
        this.billingDetail = billingDetail;
        this.merchantRepository = merchantRepository;
        this.paymentService = paymentService;
    }

    public Result handle(RequestForm requestForm) {
        try {
            if (requestForm == null || !requestForm.isValid()) {
                throw new RequiredFieldMissing();
            }
        } catch (IllegalArgumentException e) {
            throw new CantParseJson();
        }
        return control(requestForm);
    }

    private Result control(RequestForm requestForm) {
        Result result = new Result();
        switch (Method.valueOf(requestForm.getMethod())) {
            case CheckPerformTransaction ->
                    result.setResult(checkPerformTransaction(new CheckPerformTransaction(requestForm.getParams())));
            case CreateTransaction ->
                    result.setResult(createTransaction(new CreateTransaction(requestForm.getParams())));
            case PerformTransaction ->
                    result.setResult(performTransaction(new PerformTransaction(requestForm.getParams())));
            case CancelTransaction ->
                    result.setResult(cancelTransaction(new CancelTransaction(requestForm.getParams())));
            case CheckTransaction -> result.setResult(checkTransaction(new CheckTransaction(requestForm.getParams())));
            case GetStatement -> result.setResult(getStatement(new GetStatement(requestForm.getParams())));
        }
        return result;
    }

    private CheckPerformTransactionResult checkPerformTransaction(CheckPerformTransaction checkPerformTransaction) {
        Order order = getOrder(checkPerformTransaction.getAccount().getOrderId());

        if (!order.isActive()) {
            throw new OrderAlreadyPayed();
        }

        if (!checkPerformTransaction.getAmount().equals(order.getAmount())) {
            throw new WrongAmount();
        }

        Transaction transaction = merchantRepository.getTransactionByOrderId(checkPerformTransaction.getAccount().getOrderId());
        if (transaction != null) {
            throw new TransactionAlreadyExists();
        }

        return CheckPerformTransactionResult.builder()
                .allow(true)
                .detail(new DetailResult(billingDetail.getReceiptType(), List.of(
                        new Item(billingDetail.getCode(), billingDetail.getTitle(), order.getAmount(),
                                billingDetail.getCount(), billingDetail.getPackageCode(),
                                billingDetail.getVatPercent()))));
    }

    private CreateTransactionResult createTransaction(CreateTransaction createTransaction) {
        Transaction transaction = merchantRepository.getTransactionByPaymeId(createTransaction.getId());
        if (transaction != null) {
            if (!transaction.getState().equals(TransactionState.STATE_IN_PROGRESS)) {
                throw new UnableToCompleteOperation();
            }
            if (System.currentTimeMillis() - transaction.getPaymeTime() > time_expired) {
                transaction.setReason(OrderCancelReason.TRANSACTION_TIMEOUT);
                transaction.setState(TransactionState.STATE_CANCELED);
                merchantRepository.saveTransaction(transaction);
                throw new UnableToCompleteOperation();
            }
            return MerchantMapper.getCreateTransactionResult(transaction);
        }

        if (!checkPerformTransaction(new CheckPerformTransaction(createTransaction.getAmount(),
                createTransaction.getAccount())).isAllow()) {
            throw new UnableToCompleteOperation();
        }

        transaction = merchantRepository.getTransactionByOrderId(createTransaction.getAccount().getOrderId());
        if (transaction != null) {
            throw new TransactionAlreadyExists();
        }

        transaction = new Transaction(createTransaction.getId(), createTransaction.getTime(), createTransaction.getAccount().getOrderId());
        merchantRepository.saveTransaction(transaction);

        return MerchantMapper.getCreateTransactionResult(transaction);
    }

    private PerformTransactionResult performTransaction(PerformTransaction performTransaction) {
        Transaction transaction = merchantRepository.getTransactionByPaymeId(performTransaction.getId());
        if (transaction == null) {
            throw new TransactionNotFound();
        }

        if (transaction.getState().equals(TransactionState.STATE_IN_PROGRESS)) {
            if (!(System.currentTimeMillis() - transaction.getPaymeTime() < time_expired)) {
                transaction.setState(TransactionState.STATE_CANCELED);
                merchantRepository.saveTransaction(transaction);
                throw new UnableToCompleteOperation();
            }
            paymentService.receive(performTransaction.getId());

            Order order = merchantRepository.getOrderById(transaction.getOrder().getOrderId());
            order.setActive(false);
            merchantRepository.saveOrder(order);

            transaction.setState(TransactionState.STATE_DONE);
            transaction.setPerformTime(new Date().getTime());
            merchantRepository.saveTransaction(transaction);

            return new PerformTransactionResult(transaction.getId(), transaction.getPerformTime(), transaction.getState().getCode());
        }

        if (transaction.getState().equals(TransactionState.STATE_DONE)) {
            return new PerformTransactionResult(transaction.getId(), transaction.getPerformTime(), transaction.getState().getCode());
        }

        throw new UnableToCompleteOperation();
    }


    private CheckTransactionResult checkTransaction(CheckTransaction checkTransaction) {
        Transaction transaction = merchantRepository.getTransactionByPaymeId(checkTransaction.getId());
        if (transaction == null) {
            throw new TransactionNotFound();
        }

        CheckTransactionResult result = MerchantMapper.getCheckTransactionresult(transaction);
        if (transaction.getState() != null) {
            result.setState(transaction.getState().getCode());
        }
        if (transaction.getReason() != null) {
            result.setReason(transaction.getReason().getCode());
        }
        return result;
    }

    private CancelTransactionResult cancelTransaction(CancelTransaction cancelTransaction) {
        Transaction transaction = merchantRepository.getTransactionByPaymeId(cancelTransaction.getId());
        if (transaction == null) {
            throw new TransactionNotFound();
        }

        if (transaction.getState().equals(TransactionState.STATE_CANCELED) ||
                transaction.getState().equals(TransactionState.STATE_POST_CANCELED)) {
            return new CancelTransactionResult(transaction.getId(), transaction.getCancelTime(), transaction.getState().getCode());
        }
        Order order = transaction.getOrder();
        if (transaction.getState().equals(TransactionState.STATE_IN_PROGRESS)) {
            order.setActive(false);
            transaction.setState(TransactionState.STATE_CANCELED);
        } else if (transaction.getState().equals(TransactionState.STATE_DONE)) {
            if (paymentService.canRefund(cancelTransaction.getId())) {
                throw new UnableToCancelTransaction();
            }
            paymentService.refund(cancelTransaction.getId());

            order.setActive(false);
            transaction.setState(TransactionState.STATE_POST_CANCELED);
        }

        merchantRepository.saveOrder(order);

        transaction.setCancelTime(new Date().getTime());
        transaction.setReason(OrderCancelReason.get(cancelTransaction.getReason()));
        merchantRepository.saveTransaction(transaction);

        return new CancelTransactionResult(transaction.getId(), transaction.getCancelTime(), transaction.getState().getCode());
    }

    private Transactions getStatement(GetStatement getStatement) {
        List<Transaction> transactions = merchantRepository.getAllTransactionsByPaymeTimeBetween(getStatement.getFrom(), getStatement.getTo());
        if (transactions == null || transactions.isEmpty()) {
            return new Transactions(new ArrayList<>());
        }
        List<GetStatementResult> result = transactions.stream().map(MerchantMapper::getStatementResult).collect(Collectors.toList());
        return new Transactions(result);
    }

    private Order getOrder(Long orderId) {
        Order order = merchantRepository.getOrderById(orderId);

        if (order == null) {
            throw new OrderNotFound();
        }
        return order;
    }
}
