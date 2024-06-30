package io.github.nazarovctrl.paymemerchantapi.dto.db;

public class Order {
    private long orderId;
    private boolean isActive;
    private long amount;

    public Order(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Order(long orderId, boolean isActive, long amount) {
        this.orderId = orderId;
        this.isActive = isActive;
        this.amount = amount;
    }

    public boolean isActive() {
        return isActive;
    }

    public long getAmount() {
        return amount;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
