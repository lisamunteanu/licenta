package csubbcluj.lisamunteanu.orderservice.service;

import csubbcluj.lisamunteanu.orderservice.model.Cart;
import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Optional<Cart> findByUser(Integer userId);

    CartEntry addToCart(Integer userId, CartEntry cartEntry);

    List<CartEntry> getAllCartEntries();

    List<CartEntryDTO> getCartEntriesByUserId(Integer userId);

    void removeOrUpdateCart(Integer userId,CartEntry cartEntry) throws Exception;

    void deleteCart(Integer userId);
}
