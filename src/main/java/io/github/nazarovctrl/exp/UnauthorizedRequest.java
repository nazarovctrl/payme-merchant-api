package io.github.nazarovctrl.exp;

public class UnauthorizedRequest extends PaymeException {
    public UnauthorizedRequest() {
        super("Unauthorized request");
    }

    @Override
    public Integer getCode() {
        return -32504;
    }

    @Override
    public String getData() {
        return "authorization";
    }
}
