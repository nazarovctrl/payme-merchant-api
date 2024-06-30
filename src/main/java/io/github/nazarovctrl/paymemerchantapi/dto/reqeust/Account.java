package io.github.nazarovctrl.paymemerchantapi.dto.reqeust;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    private Long orderId;

    @JsonCreator
    public Account(@JsonProperty("order_id") Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public boolean isValid() {
        return orderId != null;
    }
}
