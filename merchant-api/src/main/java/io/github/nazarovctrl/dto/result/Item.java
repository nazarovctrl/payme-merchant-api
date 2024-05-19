package io.github.nazarovctrl.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private String code;
    private String title;
    private long price;
    private int count;
    @JsonProperty("package_code")
    private String packageCode;
    @JsonProperty("vat_percent")
    private int vatPercent;

    public Item(String code, String title, long price, int count, String packageCode, int vatPercent) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.count = count;
        this.packageCode = packageCode;
        this.vatPercent = vatPercent;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public long getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public int getVatPercent() {
        return vatPercent;
    }
}
