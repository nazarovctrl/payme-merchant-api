package io.github.nazarovctrl.dto.reqeust;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    @JsonProperty("order_id")
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public boolean isValid() {
        return orderId != null;
    }
}
