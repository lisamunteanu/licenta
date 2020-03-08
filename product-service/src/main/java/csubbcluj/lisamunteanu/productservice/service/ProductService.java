package csubbcluj.lisamunteanu.productservice.service;

import csubbcluj.lisamunteanu.productservice.model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> findAll();
}
