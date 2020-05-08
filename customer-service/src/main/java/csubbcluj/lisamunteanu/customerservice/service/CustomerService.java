package csubbcluj.lisamunteanu.customerservice.service;

import csubbcluj.lisamunteanu.customerservice.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Optional<Customer> findByName(String username);

    Optional<Customer> findById(Integer id);
}
