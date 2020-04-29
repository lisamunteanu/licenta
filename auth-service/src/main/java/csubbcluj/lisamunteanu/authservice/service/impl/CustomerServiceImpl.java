package csubbcluj.lisamunteanu.authservice.service.impl;

import csubbcluj.lisamunteanu.authservice.dao.CustomerDao;
import csubbcluj.lisamunteanu.authservice.model.CustomUser;
import csubbcluj.lisamunteanu.authservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<CustomUser> findAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Optional<CustomUser> findByName(String username) {
        return customerDao.findByUsername(username);
    }
}
