package csubbcluj.lisamunteanu.orderservice.model;

import java.util.List;

public class CartEntriesList {
    List<CartEntry> cartEntries;

    public CartEntriesList(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public CartEntriesList() {
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public void setCartEntries(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }
}
