package csubbcluj.lisamunteanu.orderservice.service;

import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;
import csubbcluj.lisamunteanu.orderservice.dtos.OrderEntryDTO;
import csubbcluj.lisamunteanu.orderservice.model.Order;
import csubbcluj.lisamunteanu.orderservice.model.OrderEntry;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAll();

    Optional<Order> findById(Integer id);

    Order placeOrder(List<CartEntryDTO> cartEntries, Integer customerId, String deliveryMode, String paymentMode, Integer quantity);

    List<Order> getOrdersByUserId(Integer userId);

    List<OrderEntry> getAllOrderEntries();

    List<OrderEntryDTO> getAllOrderEntriesWithID();
}
