package csubbcluj.lisamunteanu.productservice.service;

import csubbcluj.lisamunteanu.productservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Integer id);
}
