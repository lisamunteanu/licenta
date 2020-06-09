package csubbcluj.lisamunteanu.orderservice.dao;

import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import csubbcluj.lisamunteanu.orderservice.model.OrderEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderEntryDao extends JpaRepository<OrderEntry,Integer> {

    @Query(value = "select * from order_entries o where c.product_id = :productId limit 1", nativeQuery = true)
    Optional<OrderEntry> findByProductId(@Param("productId") Integer productId);

    @Query(value="select oe.id,oe.name,oe.brand,oe.description,oe.product_id,oe.price_with_vat," +
            "oe.price_without_vat,oe.price_discount,oe.price_vat,rel.order_id,o.user_id,o.date from order_entries oe inner join " +
            "order_to_order_entry rel on oe.id=rel.order_entry_id inner join orders o on rel.order_id = o.id", nativeQuery = true)
    List<Object[]> findAllWithOrderId();
}
