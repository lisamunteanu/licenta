package csubbcluj.lisamunteanu.orderservice.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderEntryDTO implements Serializable {
    private Integer id;
    private String productName;
    private String productBrand;
    private String productImage;
    private String productDescription;
    private Integer productId;
    private Double priceWithVAT;
    private Double priceWithoutVAT;
    private Double discount;
    private Double productPriceVAT;
    private Integer orderId;
    private Integer customerId;
    private LocalDateTime orderDate;
    private Integer quantity;

    public OrderEntryDTO(Integer id, String productName, String productBrand, String productDescription,
                         Integer productId, Double priceWithVAT, Double priceWithoutVAT, Double discount,
                         Double productPriceVAT, Integer orderId, Integer customerId, LocalDateTime orderDate, Integer quantity,String productImage) {
        this.id = id;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productId = productId;
        this.priceWithVAT = priceWithVAT;
        this.priceWithoutVAT = priceWithoutVAT;
        this.discount = discount;
        this.productPriceVAT = productPriceVAT;
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.quantity = quantity;
    }

    public OrderEntryDTO() {
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
