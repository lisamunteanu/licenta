package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_to_cartenetry")
public class CartToCartEntryRelation implements Serializable {

    @EmbeddedId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @EmbeddedId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cartentry")
    private CartEntry cartEntry;

    @Column(name = "quantity")
    private Integer quantity;

    public CartToCartEntryRelation() {
    }

    public CartToCartEntryRelation(Cart cart, CartEntry cartEntry, Integer quantity) {
        this.cart = cart;
        this.cartEntry = cartEntry;
        this.quantity = quantity;
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
