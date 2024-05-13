package io.github.nazarovctrl.dto.result;

import com.google.gson.annotations.SerializedName;

public class PerformTransactionResult {
    private String transaction;
    @SerializedName("perform_time")
    private Long performTime;
    private Integer state;

    public PerformTransactionResult(String transaction, Long performTime, Integer state) {
        this.transaction = transaction;
        this.performTime = performTime;
        this.state = state;
    }

    public String getTransaction() {
        return transaction;
    }

    public Long getPerformTime() {
        return performTime;
    }

    public Integer getState() {
        return state;
    }
}
