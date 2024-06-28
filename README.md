[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.nazarovctrl/payme-merchant-api/badge.svg)](https://mvnrepository.com/artifact/io.github.nazarovctrl/payme-merchant-api)

## [Java documentation](https://javadoc.io/doc/io.github.nazarovctrl/payme-merchant-api/1.0.1-beta)
## Library [link](https://central.sonatype.com/artifact/io.github.nazarovctrl/payme-merchant-api/1.0.1-beta) in Maven Central
## Maven dependency

```
<dependency>
    <groupId>io.github.nazarovctrl</groupId>
    <artifactId>payme-merchant-api</artifactId>
    <version>1.0.1-beta</version>
</dependency>
```
## How to use library?
#### 

#### 1.Add Payme authorization credentials and billing details to <tt><b>application.properties</b></tt>

```
### Reqeust path of Merchant API
payme.merchant-api.path=

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
import io.github.nazarovctrl.dto.db.Order;
import io.github.nazarovctrl.dto.db.Transaction;
import io.github.nazarovctrl.repository.IMerchantRepository;

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
    public void saveTransaction(Transaction transaction) {
        // write logic saving transaction
    }

    @Override
    public void saveOrder(Order order) {
        // write logic saving order
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
import io.github.nazarovctrl.service.IPaymentService;

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
