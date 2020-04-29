package csubbcluj.lisamunteanu.customerservice.dao;

import csubbcluj.lisamunteanu.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {

    @Query(value ="select * from customers c where c.username = :username limit 1" ,nativeQuery = true)
    Optional<Customer> findByUsername(@Param("username") String username);
}
