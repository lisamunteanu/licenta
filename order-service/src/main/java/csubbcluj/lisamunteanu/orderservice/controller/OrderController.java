package csubbcluj.lisamunteanu.orderservice.controller;

import csubbcluj.lisamunteanu.orderservice.dtos.OrderEntryDTO;
import csubbcluj.lisamunteanu.orderservice.model.CartEntriesList;
import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.model.Order;
import csubbcluj.lisamunteanu.orderservice.model.OrderEntry;
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
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/place-order")
    public ResponseEntity<Order> placeOrder(@RequestBody CartEntriesList cartEntries, @RequestParam("customerId") String customerId,
                                            @RequestParam("deliveryMode") String deliveryMode,
                                            @RequestParam("paymentMode") String paymentMode,
                                            @RequestParam("quantity") String quantity) {
        Order order = orderService.placeOrder(cartEntries.getCartEntries(), Integer.parseInt(customerId), deliveryMode, paymentMode, Integer.parseInt(quantity));
        if (Objects.nonNull(order.getId())) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/by")
    public ResponseEntity<List<Order>> getAllOrdersByCustomerId(@RequestParam("customerId") Integer customerId) {
        List<Order> ordersByUserId = orderService.getOrdersByUserId(customerId);
        HttpStatus httpStatus;
        if(ordersByUserId.isEmpty()){
            httpStatus = HttpStatus.NO_CONTENT;
        }
        else{
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(ordersByUserId, httpStatus);
    }

    @GetMapping("/order-entries")
    public ResponseEntity<List<OrderEntryDTO>> getAllOrderEntries(){
        List<OrderEntryDTO> allOrderEntries = orderService.getAllOrderEntriesWithID();
        HttpStatus httpStatus;
        if(allOrderEntries.isEmpty()){
            httpStatus = HttpStatus.NO_CONTENT;
        }
        else{
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(allOrderEntries,httpStatus);
    }
}
