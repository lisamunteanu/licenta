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

    @Column(name = "priceWithVAT")
    private Double priceWithVAT;

    @Column(name = "priceWithoutVAT")
    private Double priceWithoutVAT;

    @Column(name = "VAT")
    private Double VAT;

    @Column(name = "discount")
    private Double discount;

    @OneToOne(mappedBy = "price")
    private Product product;

    public Price() {
    }

    public Price(Double priceWithVAT, Double priceWithoutVAT, Double VAT, Double discount, Product product) {
        this.priceWithVAT = priceWithVAT;
        this.priceWithoutVAT = priceWithoutVAT;
        this.VAT = VAT;
        this.discount = discount;
        this.product = product;
    }

    public Double getPriceWithVAT() {
        return priceWithVAT;
    }

    public void setPriceWithVAT(Double priceWithVAT) {
        this.priceWithVAT = priceWithVAT;
    }

    public Double getPriceWithoutVAT() {
        return priceWithoutVAT;
    }

    public void setPriceWithoutVAT(Double priceWithoutVAT) {
        this.priceWithoutVAT = priceWithoutVAT;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}