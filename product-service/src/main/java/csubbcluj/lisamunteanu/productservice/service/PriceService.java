package csubbcluj.lisamunteanu.productservice.service;

import csubbcluj.lisamunteanu.productservice.model.Price;

import java.util.List;
import java.util.Optional;

public interface PriceService {
    Optional<Price> findById(Integer id);

    List<Price> getAllPrices();

    Price save(Price price);
}
