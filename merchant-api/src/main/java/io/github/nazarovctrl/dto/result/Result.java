package io.github.nazarovctrl.dto.result;

public class Result {
    private Object result;
    private Error error;

    public Result() {
    }

    public Result(Error error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}