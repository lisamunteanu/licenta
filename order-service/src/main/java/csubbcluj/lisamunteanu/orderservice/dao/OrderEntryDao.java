package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.OrderEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntryDao extends JpaRepository<OrderEntry,Integer> {
}
