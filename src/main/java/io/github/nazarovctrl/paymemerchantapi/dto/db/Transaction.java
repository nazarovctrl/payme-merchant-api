package io.github.nazarovctrl.paymemerchantapi.dto.db;

import io.github.nazarovctrl.paymemerchantapi.enums.OrderCancelReason;
import io.github.nazarovctrl.paymemerchantapi.enums.TransactionState;

public class Transaction {
    private String id;
    private String paymeId;
    private long paymeTime;
    private long createTime;
    private long performTime;
    private long cancelTime;
    private OrderCancelReason reason;
    private TransactionState state;
    private Order order;

    public Transaction(String id, String paymeId, long paymeTime, long createTime, long performTime, long cancelTime, OrderCancelReason reason, TransactionState state, Order order) {
        this.id = id;
        this.paymeId = paymeId;
        this.paymeTime = paymeTime;
        this.createTime = createTime;
        this.performTime = performTime;
        this.cancelTime = cancelTime;
        this.reason = reason;
        this.state = state;
        this.order = order;
    }

    public Transaction(String paymeId, long paymeTime, Long orderId) {
        this.paymeId = paymeId;
        this.paymeTime = paymeTime;
        this.order = new Order(orderId);
    }

    public String getPaymeId() {
        return paymeId;
    }

    public long getPaymeTime() {
        return paymeTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getPerformTime() {
        return performTime;
    }

    public long getCancelTime() {
        return cancelTime;
    }

    public OrderCancelReason getReason() {
        return reason;
    }

    public TransactionState getState() {
        return state;
    }

    public void setPaymeId(String paymeId) {
        this.paymeId = paymeId;
    }

    public void setPaymeTime(long paymeTime) {
        this.paymeTime = paymeTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setPerformTime(long performTime) {
        this.performTime = performTime;
    }

    public void setCancelTime(long cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReason(OrderCancelReason reason) {
        this.reason = reason;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }
}
