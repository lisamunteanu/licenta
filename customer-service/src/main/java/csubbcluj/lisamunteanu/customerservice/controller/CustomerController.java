package csubbcluj.lisamunteanu.customerservice.controller;

import csubbcluj.lisamunteanu.customerservice.clients.OrderClient;
import csubbcluj.lisamunteanu.customerservice.model.Customer;
import csubbcluj.lisamunteanu.customerservice.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = {"*"}
)
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private OrderClient orderClient;

    public CustomerController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

//    @GetMapping("/{id}")
//    public Customer getCustomerById(@PathVariable int id) {
//        return customers.stream()
//                .filter(customer -> customer.getId() == id)
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }

    @GetMapping("/{id}/orders")
    public Object getOrdersForCustomer(@PathVariable int id) {
        return orderClient.getOrdersForCustomer(id);
    }

    @PostMapping("/register")
    public HttpStatus register(@RequestBody Customer customer){
        Optional<Customer> optCustomer = customerService.findByName(customer.getUsername());
        if(optCustomer.isPresent()){
           return HttpStatus.IM_USED;
        }
        else{
            customerService.saveCustomer(customer);
            return HttpStatus.OK;
        }
    }

    @GetMapping("/by")
    public ResponseEntity<?> findCustomerByName(@RequestParam String username) {
        Optional<Customer> optionalCustomer = customerService.findByName(username);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
