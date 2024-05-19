package io.github.nazarovctrl.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CancelTransactionResult {
    private String transaction;
    @JsonProperty("cancel_time")
    private long cancelTime;
    private Integer state;

    public CancelTransactionResult(String transaction, long cancelTime, Integer state) {
        this.transaction = transaction;
        this.cancelTime = cancelTime;
        this.state = state;
    }

    public String getTransaction() {
        return transaction;
    }

    public long getCancelTime() {
        return cancelTime;
    }

    public Integer getState() {
        return state;
    }
}
