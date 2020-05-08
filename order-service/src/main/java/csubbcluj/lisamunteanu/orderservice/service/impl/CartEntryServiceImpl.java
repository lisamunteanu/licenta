package csubbcluj.lisamunteanu.orderservice.service.impl;

import csubbcluj.lisamunteanu.orderservice.dao.CartEntryDao;
import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.service.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartEntryServiceImpl implements CartEntryService {
    @Autowired
    private CartEntryDao cartEntryDao;

    @Override
    public Optional<CartEntry> findById(Integer id) {
        return cartEntryDao.findById(id);
    }
}
