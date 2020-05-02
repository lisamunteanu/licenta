package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.CartToCartEntryId;
import csubbcluj.lisamunteanu.orderservice.model.CartToCartEntryRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartToCartEntryRelationDao extends JpaRepository<CartToCartEntryRelation, CartToCartEntryId> {
}
