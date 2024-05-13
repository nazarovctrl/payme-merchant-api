package io.github.nazarovctrl.dto.result;

import com.google.gson.annotations.SerializedName;

public class CheckTransactionResult {
    @SerializedName("create_time")
    private long createTime;
    @SerializedName("perform_time")
    private long performTime;
    @SerializedName("cancel_time")
    private long cancelTime;
    private String transaction;
    private Integer state;
    private Integer reason;

    public CheckTransactionResult(long createTime, long performTime, long cancelTime, String transaction, Integer state, Integer reason) {
        this.createTime = createTime;
        this.performTime = performTime;
        this.cancelTime = cancelTime;
        this.transaction = transaction;
        this.state = state;
        this.reason = reason;
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
}
