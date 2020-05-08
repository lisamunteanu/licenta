package csubbcluj.lisamunteanu.productservice.controller;

import csubbcluj.lisamunteanu.productservice.model.Category;
import csubbcluj.lisamunteanu.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(
        origins = {"*"}
)
@RestController
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
    public ResponseEntity<Category> findProductById(@PathVariable String categoryId) {
        Optional<Category> optionalCategory = categoryService.findById(Integer.parseInt(categoryId));
        if (optionalCategory.isPresent()) {
            return new ResponseEntity<>(optionalCategory.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Category) null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        if (Objects.isNull(savedCategory.getId())) {
            return new ResponseEntity<>(category, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>((Category) null, HttpStatus.OK);
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Category>> getUniverseCategories(){
        List<Category> universes = categoryService.getAllUniverseCategories();
        return new ResponseEntity<>(universes,HttpStatus.OK);
    }
}
