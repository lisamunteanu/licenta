package csubbcluj.lisamunteanu.orderservice.controller;

import csubbcluj.lisamunteanu.orderservice.converters.CartEntryConverter;
import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;
import csubbcluj.lisamunteanu.orderservice.service.CartEntryService;
import csubbcluj.lisamunteanu.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = {"*"}
)
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartEntryService cartEntryService;

    @Autowired
    private CartEntryConverter cartEntryConverter;

    @PostMapping("/cart/add-to-cart")
    public ResponseEntity<CartEntryDTO> addTocart(@RequestBody CartEntryDTO cartEntryDTO, @RequestParam("userId") String userId){
        CartEntry cartEntry = cartEntryConverter.convertDtoToModel(cartEntryDTO);

        CartEntry resultEntry = this.cartService.addToCart(Integer.parseInt(userId),cartEntry);
        CartEntryDTO response = cartEntryConverter.convertModelToDto(resultEntry);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/cart/cart-entries")
    public ResponseEntity<List<CartEntry>> getCartEntries(){
        return new ResponseEntity<>(cartService.getAllCartEntries(),HttpStatus.OK);
    }

    @GetMapping("/cart/cart-entries/by")
    public ResponseEntity<List<CartEntryDTO>> getCartEntriesByUserId(@RequestParam("userId") String userId){
        return new ResponseEntity<>(cartService.getCartEntriesByUserId(Integer.parseInt(userId)),HttpStatus.OK);
    }

    @DeleteMapping("/cart/cart-entries/by")
    public ResponseEntity deleteFromCart(@RequestParam("cartEntryId") String cartEntryId, @RequestParam("userId") String userId) {
        Optional<CartEntry> cartEntry = cartEntryService.findById(Integer.parseInt(cartEntryId));
        try {
            this.cartService.removeOrUpdateCart(Integer.parseInt(userId), cartEntry.get());
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
