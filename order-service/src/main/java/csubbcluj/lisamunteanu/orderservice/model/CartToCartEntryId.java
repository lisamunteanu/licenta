package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CartToCartEntryId implements Serializable {

    private Integer cartId;
    private Integer cartEntryId;

    public CartToCartEntryId() {
    }

    public CartToCartEntryId(Integer cartId, Integer cartEntryId) {
        this.cartId = cartId;
        this.cartEntryId = cartEntryId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartEntryId() {
        return cartEntryId;
    }

    public void setCartEntryId(Integer cartEntryId) {
        this.cartEntryId = cartEntryId;
    }
}
