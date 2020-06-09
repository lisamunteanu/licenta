package csubbcluj.lisamunteanu.orderservice.service.impl;

import csubbcluj.lisamunteanu.orderservice.dao.CartDao;
import csubbcluj.lisamunteanu.orderservice.dao.CartEntryDao;
import csubbcluj.lisamunteanu.orderservice.dao.CartToCartEntryRelationDao;
import csubbcluj.lisamunteanu.orderservice.model.Cart;
import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.model.CartToCartEntryId;
import csubbcluj.lisamunteanu.orderservice.model.CartToCartEntryRelation;
import csubbcluj.lisamunteanu.orderservice.service.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartEntryServiceImpl implements CartEntryService {
    @Autowired
    private CartEntryDao cartEntryDao;
    @Autowired
    private CartToCartEntryRelationDao relationDao;
    @Autowired
    private CartDao cartDao;

    @Override
    public Optional<CartEntry> findById(Integer id) {
        return cartEntryDao.findById(id);
    }

    @Override
    public void deleteCartEntries(List<CartEntry> cartEntries, Integer customerId) {
        CartToCartEntryId id;
        for (CartEntry cartEntry : cartEntries) {
            Optional<Cart> cart = cartDao.findByUser(customerId);
            id = new CartToCartEntryId(cart.get().getId(), cartEntry.getId());
            Optional<CartToCartEntryRelation> relation = relationDao.findById(id);
            if(relation.isPresent()){
                relationDao.delete(relation.get());
            }
            this.cartEntryDao.delete(cartEntry);
        }
    }
}
