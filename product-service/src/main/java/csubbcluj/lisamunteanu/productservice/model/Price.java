package csubbcluj.lisamunteanu.productservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prices")
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "finalPrice")
    private Double finalPrice;

    @Column(name = "priceWithoutVAT")
    private Double priceWithoutVAT;

    @Column(name = "vat")
    private Double vat;

    @Column(name = "fullPrice")
    private Double fullPrice;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "currency")
    private String currency;

    public Price() {
    }

    public Price(Double finalPrice, Double priceWithoutVAT, Double vat, Double fullPrice, Double discount, String currency) {
        this.finalPrice = finalPrice;
        this.priceWithoutVAT = priceWithoutVAT;
        this.vat = vat;
        this.fullPrice = fullPrice;
        this.discount = discount;
        this.currency = currency;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getPriceWithoutVAT() {
        return priceWithoutVAT;
    }

    public void setPriceWithoutVAT(Double priceWithoutVAT) {
        this.priceWithoutVAT = priceWithoutVAT;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
