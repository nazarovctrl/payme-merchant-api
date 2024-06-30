package io.github.nazarovctrl.paymemerchantapi.mapper;

import io.github.nazarovctrl.paymemerchantapi.dto.db.Transaction;
import io.github.nazarovctrl.paymemerchantapi.dto.reqeust.Account;
import io.github.nazarovctrl.paymemerchantapi.dto.result.CheckTransactionResult;
import io.github.nazarovctrl.paymemerchantapi.dto.result.CreateTransactionResult;
import io.github.nazarovctrl.paymemerchantapi.dto.result.GetStatementResult;

/***
 * Class for mapping request Oo jects
 */
public class MerchantMapper {
    public static CreateTransactionResult getCreateTransactionResult(Transaction transaction) {
        return new CreateTransactionResult(transaction.getCreateTime(), transaction.getId(),
                transaction.getState().getCode());
    }

    public static GetStatementResult getStatementResult(Transaction transaction) {
        GetStatementResult getStatementResult = GetStatementResult.builder()
                .id(transaction.getPaymeId())
                .time(transaction.getPaymeTime())
                .amount(transaction.getOrder().getAmount())
                .account(new Account(transaction.getOrder().getOrderId()))
                .createTime(transaction.getCreateTime())
                .performTime(transaction.getPerformTime())
                .cancelTime(transaction.getCancelTime())
                .transaction(transaction.getId());
        if (transaction.getState() != null) {
            getStatementResult.setState(transaction.getState().getCode());
        }
        if (transaction.getReason() != null) {
            getStatementResult.setReason(transaction.getReason().getCode());
        }
        return getStatementResult;
    }

    public static CheckTransactionResult getCheckTransactionresult(Transaction transaction) {
        return new CheckTransactionResult(transaction.getCreateTime(), transaction.getPerformTime(),
                transaction.getCancelTime(), transaction.getId());
    }
}
