package io.github.nazarovctrl.service;

import io.github.nazarovctrl.dto.reqeust.*;
import io.github.nazarovctrl.dto.result.*;
import io.github.nazarovctrl.enums.Method;
import io.github.nazarovctrl.exp.*;

import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    public Result handle(RequestForm requestForm) {
        try {
            if (requestForm.isValid()) {
                throw new RequiredFieldMissing();
            }
        } catch (Exception e) {
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
        return null;
    }

    private CreateTransactionResult createTransaction(CreateTransaction createTransaction) {
        return null;
    }

    private CheckPerformTransactionResult performTransaction(PerformTransaction performTransaction) {
        return null;
    }


    private CheckTransactionResult checkTransaction(CheckTransaction checkTransaction) {
        return null;
    }

    private CancelTransactionResult cancelTransaction(CancelTransaction cancelTransaction) {
        return null;
    }

    private GetStatementResult getStatement(GetStatement getStatement) {
        return null;
    }
}
