package csubbcluj.lisamunteanu.orderservice.controller;

import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.model.CartEntryDTO;
import csubbcluj.lisamunteanu.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"*"}
)
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/cart/add-to-cart")
    public ResponseEntity<CartEntry> addTocart(@RequestBody CartEntry cartEntry, @RequestParam("userId") String userId){
        CartEntry cartEntry1 = this.cartService.addToCart(Integer.parseInt(userId),cartEntry);
        return new ResponseEntity<>(cartEntry1, HttpStatus.OK);
    }

    @GetMapping("/cart/cart-entries")
    public ResponseEntity<List<CartEntry>> getCartEntries(){
        return new ResponseEntity<>(cartService.getAllCartEntries(),HttpStatus.OK);
    }

    @GetMapping("/cart/cart-entries/by")
    public ResponseEntity<List<CartEntryDTO>> getCartEntriesByUserId(@RequestParam("userId") String userId){
        return new ResponseEntity<>(cartService.getCartEntriesByUserId(Integer.parseInt(userId)),HttpStatus.OK);
    }
}
