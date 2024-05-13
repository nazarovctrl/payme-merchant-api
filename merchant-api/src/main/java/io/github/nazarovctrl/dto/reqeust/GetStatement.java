package io.github.nazarovctrl.dto.reqeust;

public class GetStatement {
    private Long from;
    private Long to;

    public GetStatement(Params params) {
        this.from=params.getFrom();
        this.to= params.getTo();;
    }

    public static boolean isValid(Params params) {
        return params.getFrom() != null && params.getTo() != null;
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }
}
