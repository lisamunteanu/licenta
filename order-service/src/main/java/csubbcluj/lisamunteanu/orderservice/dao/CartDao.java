package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer> {

    @Query(value ="select * from carts c where c.user_id = :userId limit 1" ,nativeQuery = true)
    Optional<Cart> findByUser(@Param("userId") Integer userId);

}
