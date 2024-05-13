package io.github.nazarovctrl.dto.reqeust;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("order_id")
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public boolean isValid() {
        return orderId != null;
    }
}
