package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_entries")
public class CartEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String productName;

    @Column(name = "brand")
    private String productBrand;

    @Column(name = "image")
    private String productImage;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "price_with_vat")
    private Double priceWithVAT;

    @Column(name = "price_without_vat")
    private Double priceWithoutVAT;

    @Column(name = "price_discount")
    private Double discount;

    @Column(name = "price_vat")
    private Double productPriceVAT;

    @Column(name = "quantity")
    private Integer quantity;

    public CartEntry() {
    }

    public CartEntry(String productName, String productBrand, String productImage, String productDescription,
                     Integer productId, Double priceWithVAT, Double priceWithoutVAT, Double discount, Double productPriceVAT, Integer quantity) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productId = productId;
        this.priceWithVAT = priceWithVAT;
        this.priceWithoutVAT = priceWithoutVAT;
        this.discount = discount;
        this.productPriceVAT = productPriceVAT;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getProductPriceVAT() {
        return productPriceVAT;
    }

    public void setProductPriceVAT(Double productPriceVAT) {
        this.productPriceVAT = productPriceVAT;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
