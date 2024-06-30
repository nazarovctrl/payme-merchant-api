package io.github.nazarovctrl.paymemerchantapi.exp;

public abstract class PaymeException extends RuntimeException {
    public PaymeException(String message) {
        super(message);
    }

    public abstract Integer getCode();

    public abstract String getData();
}
