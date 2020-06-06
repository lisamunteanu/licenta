package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_to_order_entry")
public class OrderToOrderEntryRelation implements Serializable {

    @EmbeddedId
    private OrderToOrderEntryId id = new OrderToOrderEntryId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderEntryId")
    private OrderEntry orderEntry;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderToOrderEntryRelation(OrderToOrderEntryId id, Order order, OrderEntry orderEntry, Integer quantity) {
        this.id = id;
        this.order = order;
        this.orderEntry = orderEntry;
        this.quantity = quantity;
    }

    public OrderToOrderEntryRelation() {
    }

    public OrderToOrderEntryId getId() {
        return id;
    }

    public void setId(OrderToOrderEntryId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderEntry getOrderEntry() {
        return orderEntry;
    }

    public void setOrderEntry(OrderEntry orderEntry) {
        this.orderEntry = orderEntry;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
