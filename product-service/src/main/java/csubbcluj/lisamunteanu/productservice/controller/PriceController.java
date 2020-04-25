package csubbcluj.lisamunteanu.productservice.controller;

import csubbcluj.lisamunteanu.productservice.model.Price;
import csubbcluj.lisamunteanu.productservice.model.Product;
import csubbcluj.lisamunteanu.productservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(
        origins = {"*"}
)
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    PriceService priceService;

    @PostMapping
    public ResponseEntity<Map<String, Price>> savePrice(@RequestBody Price price) {
        Price savedPrice = priceService.save(price);
        Map<String, Price> response = new HashMap<>();
        if (Objects.isNull(savedPrice.getId())) {
            response.put("Error while saving the price", null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("Price saved", savedPrice);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
