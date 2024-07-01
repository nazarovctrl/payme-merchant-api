package io.github.nazarovctrl.paymemerchantapi.dto.reqeust;

public class CheckPerformTransaction {
    private Long amount;
    private Account account;

    public CheckPerformTransaction(Params params) {
        this(params.getAmount(), params.getAccount());
    }

    public CheckPerformTransaction(Long amount, Account account) {
        this.amount = amount;
        this.account = account;
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
