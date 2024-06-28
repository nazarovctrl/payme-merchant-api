package io.github.nazarovctrl.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTransactionResult {
    @JsonProperty("create_time")
    private long createTime;
    private String transaction;
    private Integer state;

    public CreateTransactionResult(long createTime, String transaction, Integer state) {
        this.createTime = createTime;
        this.transaction = transaction;
        this.state = state;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getTransaction() {
        return transaction;
    }

    public Integer getState() {
        return state;
    }
}
