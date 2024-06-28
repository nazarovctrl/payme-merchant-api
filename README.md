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
        return null;
    }

    @Override
    public Transaction getTransactionByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Transaction getTransactionByPaymeId(String id) {
        return null;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
    }

    @Override
    public void saveOrder(Order order) {
    }

    @Override
    public List<Transaction> getAllTransactionsByPaycomTimeBetween(long from, long to) {
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
    }

    @Override
    public boolean canRefund(String id) {
        return false;
    }

    @Override
    public void refund(String id) {
    }
}
````
#### 4. Run it and use it 😉
