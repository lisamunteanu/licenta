package csubbcluj.lisamunteanu.orderservice.dtos;

import java.io.Serializable;

public class CartEntryDTO implements Serializable {
    private Integer id;
    private Integer productId;
    private String productName;
    private String productImage;
    private String productBrand;
    private String productDescription;
    private Integer quantity;

    public CartEntryDTO() {
    }

    public CartEntryDTO(Integer id, Integer productId, String productName, String productImage, String productBrand,String productDescription, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
