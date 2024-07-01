package io.github.nazarovctrl.paymemerchantapi.exp;

public class UnableToCancelTransaction extends PaymeException {
    public UnableToCancelTransaction() {
        super("Unable cancel transaction");
    }

    @Override
    public Integer getCode() {
        return -31007;
    }

    @Override
    public String getData() {
        return "transaction";
    }
}
