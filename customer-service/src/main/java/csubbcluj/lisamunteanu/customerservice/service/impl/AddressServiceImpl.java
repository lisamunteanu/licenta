package csubbcluj.lisamunteanu.customerservice.service.impl;

import csubbcluj.lisamunteanu.customerservice.dao.AddressDao;
import csubbcluj.lisamunteanu.customerservice.dao.AddressToCustomerDao;
import csubbcluj.lisamunteanu.customerservice.dao.CustomerDao;
import csubbcluj.lisamunteanu.customerservice.model.Address;
import csubbcluj.lisamunteanu.customerservice.model.AddressToCustomerId;
import csubbcluj.lisamunteanu.customerservice.model.AddressToCustomerRelation;
import csubbcluj.lisamunteanu.customerservice.model.Customer;
import csubbcluj.lisamunteanu.customerservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private AddressToCustomerDao addressToCustomerDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Address saveAddress(Address address, String type, Integer customerId) {
        Address savedAddress = addressDao.save(address);
        Optional<Customer> customer = customerDao.findById(customerId);
        AddressToCustomerId relationId = new AddressToCustomerId(savedAddress.getId(),customerId);
        addressToCustomerDao.save(new AddressToCustomerRelation(relationId,savedAddress,customer.get(),type));
        return savedAddress;
    }

    @Override
    public List<Address> getAllByCustomer(Integer customerId) {
        return addressDao.findAllByCustomerId(customerId);
    }
}
