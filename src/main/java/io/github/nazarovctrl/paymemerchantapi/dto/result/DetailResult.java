package io.github.nazarovctrl.paymemerchantapi.dto.result;

import java.util.List;

public class DetailResult {
    private int receipt_type;
    private List<Item> items;

    public DetailResult(int receipt_type, List<Item> items) {
        this.receipt_type = receipt_type;
        this.items = items;
    }

    public int getReceipt_type() {
        return receipt_type;
    }

    public List<Item> getItems() {
        return items;
    }
}
