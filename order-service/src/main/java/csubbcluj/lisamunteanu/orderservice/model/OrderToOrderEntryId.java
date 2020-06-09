package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderToOrderEntryId implements Serializable {
    private Integer orderId;
    private Integer orderEntryId;


    public OrderToOrderEntryId() {
    }


    public OrderToOrderEntryId(Integer orderId, Integer orderEntryId) {
        this.orderId = orderId;
        this.orderEntryId = orderEntryId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderEntryId() {
        return orderEntryId;
    }

    public void setOrderEntryId(Integer orderEntryId) {
        this.orderEntryId = orderEntryId;
    }
}
