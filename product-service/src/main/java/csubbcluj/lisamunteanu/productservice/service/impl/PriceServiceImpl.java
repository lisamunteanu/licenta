package csubbcluj.lisamunteanu.productservice.service.impl;

import csubbcluj.lisamunteanu.productservice.dao.PriceDao;
import csubbcluj.lisamunteanu.productservice.model.Price;
import csubbcluj.lisamunteanu.productservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceDao priceDao;

    @Override
    public Optional<Price> findById(Integer id) {
        return priceDao.findById(id);
    }

    @Override
    public List<Price> getAllPrices() {
        return priceDao.findAll();
    }

    @Override
    public Price save(Price price) {
        return priceDao.save(price);
    }
}
