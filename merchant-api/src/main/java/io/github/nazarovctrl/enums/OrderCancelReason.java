package io.github.nazarovctrl.enums;

public enum OrderCancelReason {
    RECEIVER_NOT_FOUND(1),
    DEBIT_OPERATION_ERROR(2),
    TRANSACTION_ERROR(3),
    TRANSACTION_TIMEOUT(4),
    MONEY_BACK(5),
    UNKNOWN_ERROR(10);
    private final int code;

    OrderCancelReason(int code) {
        this.code = code;
    }

    public static OrderCancelReason get(Integer reason) {
        return switch (reason) {
            case 1 -> RECEIVER_NOT_FOUND;
            case 2 -> DEBIT_OPERATION_ERROR;
            case 3 -> TRANSACTION_ERROR;
            case 4 -> TRANSACTION_TIMEOUT;
            case 5 -> MONEY_BACK;
            case 10 -> UNKNOWN_ERROR;
            default -> null;
        };
    }

    public int getCode() {
        return code;
    }
}
