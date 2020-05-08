package csubbcluj.lisamunteanu.orderservice.controller;

import csubbcluj.lisamunteanu.orderservice.model.Order;
import csubbcluj.lisamunteanu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(
        origins = {"*"}
)
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        Optional<Order> optionalOrder = orderService.findById(Integer.parseInt(orderId));
        if (optionalOrder.isPresent()) {
            return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAll(),HttpStatus.OK);
    }

//    @GetMapping
//    public List<Order> getAllOrders(@RequestParam(required = false) Integer customerId) {
//        if (customerId != null) {
//            return orders.stream()
//                    .filter(order -> customerId.equals(order.getCustomerId()))
//                    .collect(Collectors.toList());
//        }
//
//        return orders;
//    }
}
