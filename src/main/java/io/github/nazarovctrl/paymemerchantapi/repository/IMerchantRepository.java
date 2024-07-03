package io.github.nazarovctrl.paymemerchantapi.repository;

import io.github.nazarovctrl.paymemerchantapi.dto.db.Order;
import io.github.nazarovctrl.paymemerchantapi.dto.db.Transaction;

import java.util.List;

/***
 * Class for getting data from the database
 *
 * @author Azimjon Nazarov
 */
public interface IMerchantRepository {
    /***
     * @param orderId Order ID
     * @return order whose orderId is equal to the orderId in the method param
     */
    Order getOrderById(Long orderId);

    /***
     * @param orderId Order ID
     * @return transaction created for this order
     */
    Transaction getTransactionByOrderId(Long orderId);

    /***
     * @param id Transaction ID generated in Payme backend
     * @return transaction whose paymeId is equal to the id in the method param
     */
    Transaction getTransactionByPaymeId(String id);

    /***
     * @param transaction Transaction to be saved
     */
    Transaction saveTransaction(Transaction transaction);

    /***
     * Change order's isActive field value and save it
     * @param orderId Order ID
     * @param isActive isActive field of Order
     */
    void changeIsActive(Long orderId, Boolean isActive);

    /***
     * @param from paymeTime
     * @param to paymeTime
     * @return list of transaction whose paymeTime between from and to
     */
    List<Transaction> getAllTransactionsByPaymeTimeBetween(long from, long to);
}
