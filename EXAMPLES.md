## Examples
#### Example for generating payment url

```java
import io.github.nazarovctrl.paymemerchantapi.util.PaymentUtil;

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
