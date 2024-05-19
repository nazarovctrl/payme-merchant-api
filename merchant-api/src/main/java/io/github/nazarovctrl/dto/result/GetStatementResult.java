package io.github.nazarovctrl.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.nazarovctrl.dto.reqeust.Account;

public class GetStatementResult {
    private String id;
    private long time;
    private Long amount;
    private Account account;
    @JsonProperty("create_time")
    private long createTime;
    @JsonProperty("perform_time")
    private long performTime;
    @JsonProperty("cancel_time")
    private long cancelTime;
    private String transaction;
    private Integer state;
    private Integer reason;

    public GetStatementResult(String id, long time, Long amount, Account account, long createTime, long performTime, long cancelTime, String transaction, Integer state, Integer reason) {
        this.id = id;
        this.time = time;
        this.amount = amount;
        this.account = account;
        this.createTime = createTime;
        this.performTime = performTime;
        this.cancelTime = cancelTime;
        this.transaction = transaction;
        this.state = state;
        this.reason = reason;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }
}
