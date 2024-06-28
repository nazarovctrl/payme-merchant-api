package io.github.nazarovctrl.dto.reqeust;

import io.github.nazarovctrl.enums.Method;

public class Params {
    private String id;
    private Account account;
    private Long amount;
    private Long time;
    private Integer reason;
    private Long from;
    private Long to;

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getTime() {
        return time;
    }

    public Integer getReason() {
        return reason;
    }

    public Long getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }

    public boolean isValidFor(Method method) {
        switch (method) {
            case CheckPerformTransaction -> {
                return CheckPerformTransaction.isValid(this);
            }
            case CreateTransaction -> {
                return CreateTransaction.isValid(this);
            }
            case PerformTransaction -> {
                return PerformTransaction.isValid(this);
            }
            case CancelTransaction -> {
                return CancelTransaction.isValid(this);
            }
            case CheckTransaction -> {
                return CheckTransaction.isValid(this);
            }
            case GetStatement -> {
                return GetStatement.isValid(this);
            }
            default -> {
                return false;
            }
        }
    }
}