package io.github.nazarovctrl.paymemerchantapi.dto.result;

import java.util.List;

public class Transactions {
    private List<GetStatementResult> transactions;

    public Transactions(List<GetStatementResult> transactions) {
        this.transactions = transactions;
    }

    public List<GetStatementResult> getTransactions() {
        return transactions;
    }
}
