package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.Cart;
import csubbcluj.lisamunteanu.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

    @Query(value ="select * from orders o where o.user_id = :userId" ,nativeQuery = true)
    List<Order> findByUserId(@Param("userId") Integer userId);
}
