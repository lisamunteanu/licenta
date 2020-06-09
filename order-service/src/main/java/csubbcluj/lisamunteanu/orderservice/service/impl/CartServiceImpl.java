package csubbcluj.lisamunteanu.orderservice.service.impl;

import csubbcluj.lisamunteanu.orderservice.dao.CartDao;
import csubbcluj.lisamunteanu.orderservice.dao.CartEntryDao;
import csubbcluj.lisamunteanu.orderservice.dao.CartToCartEntryRelationDao;
import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;
import csubbcluj.lisamunteanu.orderservice.model.*;
import csubbcluj.lisamunteanu.orderservice.service.CartService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
            if (Objects.nonNull(o[0])) {
                cartEntry.setId(Integer.parseInt(o[0].toString()));
            }
            if (Objects.nonNull(o[1])) {
                cartEntry.setProductId(Integer.parseInt(o[1].toString()));
            }
            if (Objects.nonNull(o[2])) {
                cartEntry.setProductName(o[2].toString());
            }
            if (Objects.nonNull(o[3])) {
                cartEntry.setProductImage(o[3].toString());
            }
            if (Objects.nonNull(o[4])) {
                cartEntry.setProductBrand(o[4].toString());
            }
            if (Objects.nonNull(o[5])) {
                cartEntry.setProductDescription(o[5].toString());
            }
            if (Objects.nonNull(o[6])) {
                cartEntry.setQuantity(Integer.parseInt(o[6].toString()));
            }
            if (Objects.nonNull(o[7])) {
                cartEntry.setPriceWithVAT(Double.parseDouble(o[7].toString()));
            }
            if (Objects.nonNull(o[8])) {
                cartEntry.setPriceWithoutVAT(Double.parseDouble(o[8].toString()));
            }
            if (Objects.nonNull(o[9])) {
                cartEntry.setVat(Double.parseDouble(o[9].toString()));
            }
            if (Objects.nonNull(o[10])) {
                cartEntry.setDiscount(Double.parseDouble(o[10].toString()));
            }
            result.add(cartEntry);
        }
        return result;
    }

    @Override
    public void removeOrUpdateCart(Integer userId, CartEntry cartEntry) throws Exception {
        Optional<Cart> optionalCart = this.findByUser(userId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            Optional<CartEntry> optionalCartEntry = cartEntryDao.findByProductId(cartEntry.getProductId());
            //verify if cart entry already exists--search by product code
            if (optionalCartEntry.isPresent()) {
                CartEntry foundCartEntry = optionalCartEntry.get();
                Optional<CartToCartEntryRelation> optRel = relationDao.findById(new CartToCartEntryId(cart.getId(), foundCartEntry.getId()));

                if (optRel.isPresent()) {
                    CartToCartEntryRelation relation = optRel.get();

                    if (relation.getQuantity() == 1) {
                        relationDao.delete(relation);
                        List<CartToCartEntryRelation> allCartEntries = relationDao.findByCartEntryId(foundCartEntry.getId());

                        //verify if the cartEntry exists in another cart/carts; if not-> delete it.
                        if (allCartEntries.isEmpty()) {
                            cartEntryDao.delete(foundCartEntry);
                        }
                        //verify if it was the last cartEntry from the cart; if true-> delete cart
                        List<CartEntry> cartEntriesOfCart = cartEntryDao.getAllByCartId(cart.getId());
                        if (cartEntriesOfCart.isEmpty()) {
                            cartDao.delete(cart);
                        }
                    } else if (relation.getQuantity() > 1) {
                        relation.setQuantity(relation.getQuantity() - 1);
                        relationDao.save(relation);
                    }
                }

            } else {
                throw new Exception("Cart entry found");
            }
        } else {
            throw new Exception("Cart not found");
        }
    }

    @Override
    public void deleteCart(Integer userId) {
        Optional<Cart> cart = cartDao.findByUser(userId);
        if(cart.isPresent()){
            cartDao.delete(cart.get());
        }
    }
}
