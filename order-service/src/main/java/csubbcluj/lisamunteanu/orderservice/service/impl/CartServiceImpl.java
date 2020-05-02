package csubbcluj.lisamunteanu.orderservice.service.impl;

import csubbcluj.lisamunteanu.orderservice.dao.CartDao;
import csubbcluj.lisamunteanu.orderservice.dao.CartEntryDao;
import csubbcluj.lisamunteanu.orderservice.dao.CartToCartEntryRelationDao;
import csubbcluj.lisamunteanu.orderservice.model.*;
import csubbcluj.lisamunteanu.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartEntryDao cartEntryDao;

    @Autowired
    private CartToCartEntryRelationDao relationDao;

    @Override
    public Optional<Cart> findByUser(Integer userId) {
        return cartDao.findByUser(userId);
    }

    @Override
    public CartEntry addToCart(Integer userId, CartEntry cartEntry) {
        Optional<Cart> optionalCart = this.findByUser(userId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            //cart for user already exists
            Optional<CartEntry> optionalCartEntry = cartEntryDao.findByProductId(cartEntry.getProductId());
            //verify if cart entry already exists--search by product code
            if (optionalCartEntry.isPresent()) {
                CartEntry foundCartEntry = optionalCartEntry.get();
                Optional<CartToCartEntryRelation> optRel = relationDao.findById(new CartToCartEntryId(cart.getId(), foundCartEntry.getId()));
                if (optRel.isPresent()) {
                    CartToCartEntryRelation relation = optRel.get();
                    Integer currentQuantity = relation.getQuantity();
                    relation.setQuantity(currentQuantity + 1);
                    relationDao.save(relation);
                }

            } else {
                cartEntryDao.save(cartEntry);
                relationDao.save(new CartToCartEntryRelation(cart, cartEntry, 1));

            }
        } else {
            Cart newCart = cartDao.save(new Cart(userId));
            cartEntryDao.save(cartEntry);
            relationDao.save(new CartToCartEntryRelation(newCart, cartEntry, 1));
        }
        return cartEntry;
    }

    @Override
    public List<CartEntry> getAllCartEntries() {
        return cartEntryDao.findAll();
    }

    @Override
    public List<CartEntryDTO> getCartEntriesByUserId(Integer userId) {
        List<Object[]> objects = cartEntryDao.findByUserId(userId);
        List<CartEntryDTO> result = new ArrayList<>();
        for (Object[] o : objects) {
            CartEntryDTO cartEntry = new CartEntryDTO();
            cartEntry.setId(Integer.parseInt(o[0].toString()));
            cartEntry.setProductId(Integer.parseInt(o[1].toString()));
            cartEntry.setProductName(o[2].toString());
            cartEntry.setProductImage(o[3].toString());
            cartEntry.setProductBrand(o[4].toString());
            cartEntry.setProductDescription(o[5].toString());
            cartEntry.setQuantity(Integer.parseInt(o[6].toString()));
            result.add(cartEntry);
        }
        return result;
    }
}
