package io.github.nazarovctrl.paymemerchantapi.exp;

public class CantParseJson extends PaymeException {

    public CantParseJson() {
        super("JSON parsing exception");
    }

    @Override
    public Integer getCode() {
        return -32700;
    }

    @Override
    public String getData() {
        return "json";
    }
}
