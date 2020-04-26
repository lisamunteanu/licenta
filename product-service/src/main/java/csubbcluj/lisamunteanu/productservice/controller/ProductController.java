package csubbcluj.lisamunteanu.productservice.controller;

import csubbcluj.lisamunteanu.productservice.model.Product;
import csubbcluj.lisamunteanu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(
        origins = {"*"}
)
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.findAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("{productId}")
    public ResponseEntity<Map<String, Product>> findProductById(@PathVariable String productId) {
        Optional<Product> optionalProduct = productService.findById(Integer.parseInt(productId));
        Map<String, Product> response = new HashMap<>();
        if (optionalProduct.isPresent()) {
            response.put("Product found", optionalProduct.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Product not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> findAllProductsByCategory(@RequestParam(name="id") String categoryId) {
        List<Product> productsFromCategory = productService.findAllProductsFromCategory(Integer.parseInt(categoryId));
        if (productsFromCategory.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productsFromCategory, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Product>> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        Map<String, Product> response = new HashMap<>();
        if (Objects.isNull(savedProduct.getId())) {
            response.put("Error while saving the product", null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("Product saved", savedProduct);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
