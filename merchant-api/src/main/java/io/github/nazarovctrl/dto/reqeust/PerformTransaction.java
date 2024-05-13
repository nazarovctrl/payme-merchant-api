package io.github.nazarovctrl.dto.reqeust;

public class PerformTransaction {
    private String id;

    public PerformTransaction(Params params) {
        this.id = params.getId();
    }

    public static boolean isValid(Params params) {
        return params.getId() != null && !params.getId().isBlank();
    }

    public String getId() {
        return id;
    }
}
