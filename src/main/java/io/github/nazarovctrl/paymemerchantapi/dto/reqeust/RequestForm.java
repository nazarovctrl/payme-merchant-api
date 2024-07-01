package io.github.nazarovctrl.paymemerchantapi.dto.reqeust;

import io.github.nazarovctrl.paymemerchantapi.enums.Method;

public class RequestForm {
    private String method;
    private Params params;

    public String getMethod() {
        return method;
    }

    public Params getParams() {
        return params;
    }

    public boolean isValid() {
        return method != null && !method.isBlank() && params != null && params.isValidFor(Method.valueOf(method));
    }
}
