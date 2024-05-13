package io.github.nazarovctrl.exp;

public class UnableToCompleteOperation extends PaymeException {
    public UnableToCompleteOperation() {
        super("Unable to complete operation");
    }

    @Override
    public Integer getCode() {
        return -31008;
    }

    @Override
    public String getData() {
        return "transaction";
    }
}
