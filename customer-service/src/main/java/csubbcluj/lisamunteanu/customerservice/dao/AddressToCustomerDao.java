package csubbcluj.lisamunteanu.customerservice.dao;

import csubbcluj.lisamunteanu.customerservice.model.AddressToCustomerId;
import csubbcluj.lisamunteanu.customerservice.model.AddressToCustomerRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressToCustomerDao extends JpaRepository<AddressToCustomerRelation, AddressToCustomerId> {
}
