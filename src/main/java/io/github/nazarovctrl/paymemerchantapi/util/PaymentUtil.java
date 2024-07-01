package io.github.nazarovctrl.paymemerchantapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

/***
 * Class for generating payment url
 */
@Component
public class PaymentUtil {
    @Value("${payme.checkout.url:https://checkout.paycom.uz/}")
    private String checkoutUrl;

    @Value("${payme.merchant.id}")
    private String merchantId;

    /***
     * Method for generating payment url
     * @param orderId ID of order
     * @param amount Payment amount
     * @return Payment url
     */
    public String generatePaymentUrl(Long orderId, Long amount) {
        String str = String.format("m=%s;ac.order_id=%s;a=%s", merchantId, orderId, amount);
        String s = Base64.getEncoder().encodeToString(str.getBytes());
        return checkoutUrl + s;
    }
}
