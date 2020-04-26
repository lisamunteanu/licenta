package csubbcluj.lisamunteanu.productservice.service;

import csubbcluj.lisamunteanu.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    List<Product> findAllProductsFromCategory(Integer categoryId);
}
