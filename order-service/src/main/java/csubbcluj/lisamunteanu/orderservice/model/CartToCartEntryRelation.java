package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_to_cartentry")
public class CartToCartEntryRelation implements Serializable {

    @EmbeddedId
    private CartToCartEntryId id = new CartToCartEntryId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartEntryId")
    private CartEntry cartEntry;

    @Column(name = "quantity")
    private Integer quantity;

    public CartToCartEntryRelation() {
    }

    public CartToCartEntryRelation(CartToCartEntryId id, Cart cart, CartEntry cartEntry, Integer quantity) {
        this.id = id;
        this.cart = cart;
        this.cartEntry = cartEntry;
        this.quantity = quantity;
    }

    public CartToCartEntryRelation(Cart cart, CartEntry cartEntry, Integer quantity) {
        this.cart = cart;
        this.cartEntry = cartEntry;
        this.quantity = quantity;
    }

    public CartToCartEntryId getId() {
        return id;
    }

    public void setId(CartToCartEntryId id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartEntry getCartEntry() {
        return cartEntry;
    }

    public void setCartEntry(CartEntry cartEntry) {
        this.cartEntry = cartEntry;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
