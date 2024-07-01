package io.github.nazarovctrl.paymemerchantapi.enums;

/***
 * Состояния транзакции (Transaction State)
 */
public enum TransactionState {
    STATE_NEW(0),
    /***
     * Транзакция успешно создана, ожидание подтверждения (начальное состояние 0)
     */
    STATE_IN_PROGRESS(1),
    /***
     * Транзакция успешно завершена (начальное состояние 1)
     */
    STATE_DONE(2),
    /***
     * Транзакция отменена (начальное состояние 1)
     */
    STATE_CANCELED(-1),
    /***
     * Транзакция отменена после завершения (начальное состояние 2)
     */
    STATE_POST_CANCELED(-2);
    private final int code;

    TransactionState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
