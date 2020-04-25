package csubbcluj.lisamunteanu.productservice.service.impl;

import csubbcluj.lisamunteanu.productservice.dao.CategoryDao;
import csubbcluj.lisamunteanu.productservice.model.Category;
import csubbcluj.lisamunteanu.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;


    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryDao.findById(id);
    }
}
