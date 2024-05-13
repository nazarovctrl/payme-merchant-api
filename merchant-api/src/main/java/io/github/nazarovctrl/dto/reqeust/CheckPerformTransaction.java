package io.github.nazarovctrl.dto.reqeust;

public class CheckPerformTransaction {
    private Long amount;
    private Account account;

    public CheckPerformTransaction(Params params) {
        this.amount = params.getAmount();
        this.account = params.getAccount();
    }

    public static boolean isValid(Params params) {
        return params.getAmount() != null && params.getAccount() != null && params.getAccount().isValid();
    }

    public Long getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }
}
