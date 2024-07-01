package io.github.nazarovctrl.paymemerchantapi.exp;

public class OrderNotFound extends PaymeException {
    public OrderNotFound() {
        super("Order not found");
    }

    @Override
    public Integer getCode() {
        return -31050;
    }

    @Override
    public String getData() {
        return "order";
    }
}
