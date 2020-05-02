package csubbcluj.lisamunteanu.orderservice.service;

import csubbcluj.lisamunteanu.orderservice.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAll();

    Optional<Order> findById(Integer id);
}
