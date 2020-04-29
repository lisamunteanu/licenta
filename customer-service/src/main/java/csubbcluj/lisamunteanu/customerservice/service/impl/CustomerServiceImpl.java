package csubbcluj.lisamunteanu.customerservice.service.impl;

import com.netflix.discovery.util.StringUtil;
import csubbcluj.lisamunteanu.customerservice.dao.CustomerDao;
import csubbcluj.lisamunteanu.customerservice.model.Customer;
import csubbcluj.lisamunteanu.customerservice.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        String username = Objects.nonNull(customer.getUsername()) ? customer.getUsername() :StringUtils.EMPTY;
        newCustomer.setUsername(username);
        newCustomer.setRole("USER");
        String encoded = new BCryptPasswordEncoder().encode(customer.getPassword());
        newCustomer.setPassword(encoded);
        String name = Objects.nonNull(customer.getName()) ? customer.getName() :StringUtils.EMPTY;
        newCustomer.setName(name);
        return customerDao.save(newCustomer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findByName(String username) {
        return customerDao.findByUsername(username);
    }
}
