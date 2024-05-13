package io.github.nazarovctrl.dto.reqeust;

public class CreateTransaction {
    private String id;
    private Long time;
    private Long amount;
    private Account account;

    public CreateTransaction(Params params) {
        this.id = params.getId();
        this.time = params.getTime();
        this.amount = params.getAmount();
        this.account = params.getAccount();
    }

    public static boolean isValid(Params params) {
        return params.getId() != null && !params.getId().isBlank() && params.getTime() != null && params.getAmount() != null
                && params.getAccount() != null && params.getAccount().isValid();
    }

    public String getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public Long getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }
}
