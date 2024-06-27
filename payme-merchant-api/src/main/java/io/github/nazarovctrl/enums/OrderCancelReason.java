package io.github.nazarovctrl.enums;

/***
 * Причина отмены транзакции (Reason)
 */
public enum OrderCancelReason {
    /***
     * Один или несколько получателей не найдены или неактивны в Payme Business
     */
    RECEIVER_NOT_FOUND(1),
    /***
     * Ошибка при выполнении дебетовой операции в процессинговом центре
     */
    DEBIT_OPERATION_ERROR(2),
    /***
     * Ошибка выполнения транзакции
     */
    TRANSACTION_ERROR(3),
    /***
     * Транзакция отменена по таймауту
     */
    TRANSACTION_TIMEOUT(4),
    /***
     * Возврат денег
     */
    MONEY_BACK(5),
    /***
     * Неизвестная ошибка
     */
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
