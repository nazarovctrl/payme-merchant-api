package io.github.nazarovctrl.paymemerchantapi.dto.reqeust;

public class CancelTransaction {
    private String id;
    private Integer reason;

    public CancelTransaction(Params params) {
        this.id = params.getId();
        this.reason = params.getReason();
    }

    public static boolean isValid(Params params) {
        return params.getId() != null && !params.getId().isBlank() && params.getReason() != null;
    }

    public String getId() {
        return id;
    }

    public Integer getReason() {
        return reason;
    }
}
