package io.github.nazarovctrl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "payme.billing.detail")
public class BillingDetail {
    private Integer receiptType;
    private String code;
    private String title;
    private int count = 1;
    private String packageCode;
    private Integer vatPercent;

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public Integer getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Integer vatPercent) {
        this.vatPercent = vatPercent;
    }
}
