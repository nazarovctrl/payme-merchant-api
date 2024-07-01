package io.github.nazarovctrl.paymemerchantapi.exp;

public class TransactionAlreadyExists extends PaymeException {
    public TransactionAlreadyExists() {
        super("Transaction already exists");
    }

    @Override
    public Integer getCode() {
        return -31099;
    }

    @Override
    public String getData() {
        return "transaction";
    }

}
