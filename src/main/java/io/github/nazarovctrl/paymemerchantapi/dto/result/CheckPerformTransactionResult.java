package io.github.nazarovctrl.paymemerchantapi.dto.result;

public class CheckPerformTransactionResult {
    public boolean allow;
    private DetailResult detail;


    public CheckPerformTransactionResult() {
    }

    public boolean isAllow() {
        return allow;
    }

    public DetailResult getDetail() {
        return detail;
    }

    public static CheckPerformTransactionResult builder() {
        return new CheckPerformTransactionResult();
    }

    public CheckPerformTransactionResult allow(boolean value) {
        this.allow = value;
        return this;
    }

    public CheckPerformTransactionResult detail(DetailResult detailResult) {
        this.detail = detailResult;
        return this;
    }
}
