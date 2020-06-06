package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.OrderToOrderEntryId;
import csubbcluj.lisamunteanu.orderservice.model.OrderToOrderEntryRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderToOrderEntryDao extends JpaRepository<OrderToOrderEntryRelation,OrderToOrderEntryId> {
}
