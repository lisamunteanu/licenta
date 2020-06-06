package csubbcluj.lisamunteanu.customerservice.controller;

import csubbcluj.lisamunteanu.customerservice.model.Address;
import csubbcluj.lisamunteanu.customerservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@CrossOrigin(
        origins = {"*"}
)
@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add-new-address")
    public ResponseEntity<HttpStatus> saveAddress(@RequestBody Address address, @RequestParam("customerId") Integer customerId,
                                                  @RequestParam("type") String type) {
        Address savedAddress = addressService.saveAddress(address, type, customerId);
        if (Objects.nonNull(savedAddress)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by")
    public ResponseEntity<List<Address>> getAllAddressesOfCustomer(@RequestParam("customerId") Integer customerId) {
        List<Address> allAddressesByCustomer = addressService.getAllByCustomer(customerId);
        if (allAddressesByCustomer.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allAddressesByCustomer, HttpStatus.OK);
        }
    }
}
