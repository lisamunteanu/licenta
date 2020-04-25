package csubbcluj.lisamunteanu.productservice.controller;

import csubbcluj.lisamunteanu.productservice.model.Category;
import csubbcluj.lisamunteanu.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(
        origins = {"*"}
)
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> all = categoryService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Map<String, Category>> findProductById(@PathVariable String categoryId) {
        Optional<Category> optionalCategory = categoryService.findById(Integer.parseInt(categoryId));
        Map<String, Category> response = new HashMap<>();
        if (optionalCategory.isPresent()) {
            response.put("Category found", optionalCategory.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Category not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Category>> saveProduct(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        Map<String, Category> response = new HashMap<>();
        if (Objects.isNull(savedCategory.getId())) {
            response.put("Error while saving the category", null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("Category saved", savedCategory);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
