package csubbcluj.lisamunteanu.orderservice.model;

import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;

import java.util.List;

public class CartEntriesList {
    List<CartEntryDTO> cartEntries;

    public CartEntriesList(List<CartEntryDTO> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public CartEntriesList() {
    }

    public List<CartEntryDTO> getCartEntries() {
        return cartEntries;
    }

    public void setCartEntries(List<CartEntryDTO> cartEntries) {
        this.cartEntries = cartEntries;
    }
}
