package io.github.nazarovctrl.paymemerchantapi.service;

/**
 * The class for receive or refund payment
 * You must implement it and create bean
 *
 * @author Azimjon Nazarov
 */
public interface IPaymentService {
    /***
     * Method for receive payment
     * You should write logic, such as what to do after successful payment
     * For example give your product to user
     * @param id Transaction ID
     */
    void receive(String id);

    /***
     * Method for checking a transaction for cancellation
     * For example, you sold a product to a user, but the user wants his money back. You should check for a product that is eligible for a refund
     * @param id Transaction ID
     * @return true if the product can be returned, otherwise false
     */
    boolean canRefund(String id);

    /***
     * Method for get a product/service from user that has been sold
     * You should write logic that will work after the user gets their money back
     * For example, you could write logic that removes a product from the user or revokes permission to use a service for the user
     * @param id Transaction ID
     */
    void refund(String id);
}
