package csubbcluj.lisamunteanu.customerservice.dao;

import csubbcluj.lisamunteanu.customerservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {

    @Query(value ="select * from addresses a inner join customer_address ac on a.id = ac.address_id where ac.customer_id = :customerId" ,nativeQuery = true)
    List<Address> findAllByCustomerId(@Param("customerId") Integer customerId);
}
