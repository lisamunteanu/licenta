package csubbcluj.lisamunteanu.customerservice.service;

import csubbcluj.lisamunteanu.customerservice.model.Address;

import java.util.List;

public interface AddressService {

    Address saveAddress(Address address, String type, Integer customerId);

    List<Address> getAllByCustomer(Integer customerId);
}
