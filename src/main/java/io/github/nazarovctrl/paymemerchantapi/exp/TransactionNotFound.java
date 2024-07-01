package io.github.nazarovctrl.paymemerchantapi.exp;

public class TransactionNotFound extends PaymeException {
    public TransactionNotFound() {
        super("Transaction not found");
    }

    @Override
    public Integer getCode() {
        return -31003;
    }

    @Override
    public String getData() {
        return "transaction";
    }
}
