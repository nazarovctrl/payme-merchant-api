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
## Usage
### [How to use library?](https://github.com/nazarovctrl/payme-merchant-api/blob/master/HOW2USE.md#how-to-use-library)

## Examples
### Example for generating payment url
```java
import io.github.nazarovctrl.util.PaymentUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private PaymentUtil paymentUtil;

    public String getPaymentUrl() {
        Long orderId = 1;
        Long amount = 1000_00L; // Сумма платежа (в тийинах)
        
        String paymentUrl = paymentUtil.generatePaymentUrl(orderId, amount);
        return paymentUrl;
    }
}
```
