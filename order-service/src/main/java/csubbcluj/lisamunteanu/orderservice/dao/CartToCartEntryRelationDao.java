package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.CartToCartEntryId;
import csubbcluj.lisamunteanu.orderservice.model.CartToCartEntryRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartToCartEntryRelationDao extends JpaRepository<CartToCartEntryRelation, CartToCartEntryId> {

    @Query(value = "select * from cart_to_cartentry c where c.cart_entry_id = :id", nativeQuery = true)
    List<CartToCartEntryRelation> findByCartEntryId(@Param("id") Integer id);
}
