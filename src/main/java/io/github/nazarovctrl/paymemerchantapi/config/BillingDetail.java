package io.github.nazarovctrl.paymemerchantapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/***
 * The class for initializing Payme billing details into variables
 *
 * @author Azimjon Nazarov
 ***/
@Configuration
@ConfigurationProperties(prefix = "payme.billing.detail")
public class BillingDetail {
    /***
     * Продажа/Возврат = 0 (required)
     */
    private Integer receiptType;
    /***
     * ИКПУ (идентификационный код продукции и услуг) (required)
     */
    private String code;
    /***
     * Название продуктa (required)
     */
    private String title;
    /***
     * Количество товаров или услуг	(required, minimum = 1)
     */
    private int count = 1;
    /***
     * Код упаковки продукта (required)
     */
    private String packageCode;
    /***
     * Процент уплачиваемого НДС для данного товара	(required)
     */
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
