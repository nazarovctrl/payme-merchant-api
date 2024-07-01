package io.github.nazarovctrl.paymemerchantapi.exp;

public class WrongAmount extends PaymeException {
    public WrongAmount() {
        super("Wrong amount");
    }

    @Override
    public Integer getCode() {
        return -31001;
    }

    @Override
    public String getData() {
        return "amount";
    }
}
