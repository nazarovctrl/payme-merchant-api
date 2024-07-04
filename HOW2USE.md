## How to use library?
#### 

#### 1.Add Payme authorization credentials and billing details to <tt><b>application.properties</b></tt>

```properties
### Merchant ID or alias
payme.merchant.id=
### Request path of Merchant API
payme.merchant.api.path=

### Basic Authorization credentials 
payme.user.name=
payme.user.password=

### Billing details
payme.billing.detail.receipt-type=
payme.billing.detail.code=
payme.billing.detail.title=
payme.billing.detail.count=
payme.billing.detail.package-code=
payme.billing.detail.vat-percent=
```

 #### 2.Implement IMerchantRepository

 ```java
import io.github.nazarovctrl.paymemerchantapi.dto.db.Order;
import io.github.nazarovctrl.paymemerchantapi.dto.db.Transaction;
import io.github.nazarovctrl.paymemerchantapi.repository.IMerchantRepository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantRepository implements IMerchantRepository {
    @Override
    public Order getOrderById(Long orderId) {
        // return order whose orderId is equal to the orderId in the method param
        return null;
    }

    @Override
    public Transaction getTransactionByOrderId(Long orderId) {
        // return transaction created for this order
        return null;
    }

    @Override
    public Transaction getTransactionByPaymeId(String id) {
        // id = Transaction ID generated in Payme backend
        // return transaction whose paymeId is equal to the id in the method param
        return null;
    }

    @Override
    public String saveTransaction(Transaction transaction) {
        // write logic saving transaction and return transactionId
    }

    @Override
    public void changeIsActive(Long orderId, Boolean isActive);
        // write logic to change the order field isActive
    }

    @Override
    public List<Transaction> getAllTransactionsByPaymeTimeBetween(long from, long to) {
        // return list of transaction whose paymeTime between from and to
        return null;
    }
}
```

#### 3.Implement IPaymentService

````java
import io.github.nazarovctrl.paymemerchantapi.service.IPaymentService;

import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    @Override
    public void receive(String id) {
        // You should write logic, such as what to do after successful payment
        // For example give your product to user
    }

    @Override
    public boolean canRefund(String id) {
        // Method for checking a transaction for cancellation
        // For example, you sold a product to a user, but the user wants his money back.
        // You should check for a product that is eligible for a refund
        return true;
    }

    @Override
    public void refund(String id) {
        // You should write logic that will work after the user gets their money back
        // For example, you could write logic that removes a product from the user 
        // or revokes permission to use a service for the user
    }
}
````
#### 4. Run it and use it 😉
