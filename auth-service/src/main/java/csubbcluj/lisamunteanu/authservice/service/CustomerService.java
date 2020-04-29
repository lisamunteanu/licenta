package csubbcluj.lisamunteanu.authservice.service;

import csubbcluj.lisamunteanu.authservice.model.CustomUser;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomUser> findAllCustomers();

    Optional<CustomUser> findByName(String username);
}
