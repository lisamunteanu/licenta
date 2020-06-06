package csubbcluj.lisamunteanu.customerservice.service.impl;

import com.netflix.discovery.util.StringUtil;
import csubbcluj.lisamunteanu.customerservice.dao.CustomerDao;
import csubbcluj.lisamunteanu.customerservice.model.Customer;
import csubbcluj.lisamunteanu.customerservice.service.CustomerService;
import csubbcluj.lisamunteanu.customerservice.service.MailService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private MailService mailService;

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        String username = Objects.nonNull(customer.getUsername()) ? customer.getUsername() : StringUtils.EMPTY;
        newCustomer.setUsername(username);
        newCustomer.setRole("USER");
        String encoded = new BCryptPasswordEncoder().encode(customer.getPassword());
        newCustomer.setPassword(encoded);
        String name = Objects.nonNull(customer.getName()) ? customer.getName() : StringUtils.EMPTY;
        newCustomer.setName(name);
        try {
            this.mailService.sendMessageUsingThymeleafTemplate(username,"Bine ati venit!",customer);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
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

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerDao.findById(id);
    }
}
