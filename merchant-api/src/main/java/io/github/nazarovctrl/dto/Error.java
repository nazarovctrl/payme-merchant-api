package io.github.nazarovctrl.dto;

public class Error {
    private Integer code;
    private String message;
    private String data;

    public Error(Integer code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}