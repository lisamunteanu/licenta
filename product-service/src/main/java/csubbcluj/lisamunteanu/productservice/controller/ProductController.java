package csubbcluj.lisamunteanu.productservice.controller;

import com.netflix.client.http.HttpResponse;
import csubbcluj.lisamunteanu.productservice.model.Product;
import csubbcluj.lisamunteanu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    public ResponseEntity<Product> findProductById(@PathVariable String productId) {
        Optional<Product> optionalProduct = productService.findById(Integer.parseInt(productId));
        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Product) null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> findAllProductsByCategory(@PathVariable String categoryId) {
        List<Product> productsFromCategory = productService.findAllProductsFromCategory(Integer.parseInt(categoryId));
        if (productsFromCategory.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsFromCategory, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        if (Objects.isNull(savedProduct.getId())) {
            return new ResponseEntity<>(savedProduct, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>((Product) null, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> findAllByKeyword(@RequestParam("keyword") String keyword){
        List<Product> foundProducts = productService.searchByKeyword(keyword);
        if(foundProducts.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(foundProducts,HttpStatus.OK);
        }
    }

    @PutMapping("/update-stock/{productId}")
    public HttpStatus updateStock(@PathVariable("productId") Integer productId,@RequestParam("quantity") String quantity){
        try {
            productService.updateStock(Integer.parseInt(quantity),productId);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
