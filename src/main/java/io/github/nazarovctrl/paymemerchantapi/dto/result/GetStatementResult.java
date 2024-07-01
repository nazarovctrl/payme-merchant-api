package io.github.nazarovctrl.paymemerchantapi.dto.result;

import io.github.nazarovctrl.paymemerchantapi.dto.reqeust.Account;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public GetStatementResult() {
    }

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

    public static GetStatementResult builder() {
        return new GetStatementResult();
    }


    public void setState(Integer state) {
        this.state = state;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public GetStatementResult id(String paymeId) {
        this.id = paymeId;
        return this;
    }

    public GetStatementResult time(long paymeTime) {
        this.time = paymeTime;
        return this;
    }

    public GetStatementResult amount(long amount) {
        this.amount = amount;
        return this;
    }

    public GetStatementResult account(Account account) {
        this.account = account;
        return this;
    }

    public GetStatementResult createTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public GetStatementResult performTime(long performTime) {
        this.performTime = performTime;
        return this;
    }

    public GetStatementResult cancelTime(long cancelTime) {
        this.cancelTime = cancelTime;
        return this;
    }

    public GetStatementResult transaction(String id) {
        this.transaction = id;
        return this;
    }
}
