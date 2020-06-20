package csubbcluj.lisamunteanu.productservice.service.impl;

import csubbcluj.lisamunteanu.productservice.dao.ProductDao;
import csubbcluj.lisamunteanu.productservice.model.Product;
import csubbcluj.lisamunteanu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAllProductsFromCategory(Integer categoryId) {
        return productDao.findAllProductsFromCategory(categoryId);
    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        return productDao.findAllByKeyword(keyword);
    }

    @Transactional
    @Override
    public void updateStock(Integer quantity, Integer productId) throws Exception {
        Optional<Product> product = productDao.findById(productId);
        if(product.isPresent()){
            productDao.updateStock(quantity,productId);
        }
        else{
            throw new Exception("Product does not exist!");
        }
    }

}
