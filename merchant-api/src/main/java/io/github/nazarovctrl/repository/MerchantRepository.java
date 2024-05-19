package io.github.nazarovctrl.repository;

import io.github.nazarovctrl.dto.db.Order;
import io.github.nazarovctrl.dto.db.Transaction;

import java.util.List;

public interface MerchantRepository {

    Order getOrderById(Long orderId);

    Transaction getTransactionByOrderId(Long orderId);

    Transaction getTransactionByPaymeId(String id);

    void saveTransaction(Transaction transaction);

    void saveOrder(Order order);

    List<Transaction> getAllTransactionsByPaycomTimeBetween(long from, long to);
}
