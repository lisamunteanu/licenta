package csubbcluj.lisamunteanu.productservice.service;

import csubbcluj.lisamunteanu.productservice.model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAllCategories();
}
