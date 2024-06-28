package io.github.nazarovctrl.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckTransactionResult {
    @JsonProperty("create_time")
    private long createTime;
    @JsonProperty("perform_time")
    private long performTime;
    @JsonProperty("cancel_time")
    private long cancelTime;
    private String transaction;
    private Integer state;
    private Integer reason;

    public CheckTransactionResult(long createTime, long performTime, long cancelTime, String transaction) {
        this.createTime = createTime;
        this.performTime = performTime;
        this.cancelTime = cancelTime;
        this.transaction = transaction;
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

    public String getTransaction() {
        return transaction;
    }

    public Integer getState() {
        return state;
    }

    public Integer getReason() {
        return reason;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }
}
