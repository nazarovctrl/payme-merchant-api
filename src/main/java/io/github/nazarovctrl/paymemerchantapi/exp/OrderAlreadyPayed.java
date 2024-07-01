package io.github.nazarovctrl.paymemerchantapi.exp;

public class OrderAlreadyPayed extends PaymeException {

    public OrderAlreadyPayed() {
        super("Invoice already paid/cancelled");
    }

    @Override
    public Integer getCode() {
        return -31099;
    }

    @Override
    public String getData() {
        return "order payed/canceled";
    }
}