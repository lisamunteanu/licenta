package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderToOrderEntryId implements Serializable {
    private Integer cartId;
    private Integer cartEntryId;


    public OrderToOrderEntryId() {
    }

    public OrderToOrderEntryId(Integer cartId, Integer cartEntryId) {
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
