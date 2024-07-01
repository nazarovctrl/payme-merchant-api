package io.github.nazarovctrl.paymemerchantapi.exp;

public class RequiredFieldMissing extends PaymeException {
    public RequiredFieldMissing() {
        super("Required field not found");
    }

    @Override
    public Integer getCode() {
        return -32600;
    }

    @Override
    public String getData() {
        return "field";
    }
}
