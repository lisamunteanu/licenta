package csubbcluj.lisamunteanu.orderservice.service.impl;

import csubbcluj.lisamunteanu.orderservice.dao.OrderDao;
import csubbcluj.lisamunteanu.orderservice.model.Order;
import csubbcluj.lisamunteanu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderDao.findById(id);
    }
}
