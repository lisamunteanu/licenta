package csubbcluj.lisamunteanu.orderservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "deliveryMode")
    private String deliveryMode;

    @Column(name = "paymentMode")
    private String paymentMode;

    @Column(name = "productsTotal")
    private Double productsTotal;

    @Column(name = "totalDiscount")
    private Double totalDiscount;

    @Column(name = "deliveryCost")
    private Double deliveryCost;

    @Column(name = "totalPrice")
    private Double totalPrice;

    public Order() {
    }

    public Order(Integer userId, LocalDateTime date, String deliveryMode, String paymentMode, Double productsTotal,
                 Double totalDiscount, Double deliveryCost, Double totalPrice) {
        this.userId = userId;
        this.date = date;
        this.deliveryMode = deliveryMode;
        this.paymentMode = paymentMode;
        this.productsTotal = productsTotal;
        this.totalDiscount = totalDiscount;
        this.deliveryCost = deliveryCost;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Double getProductsTotal() {
        return productsTotal;
    }

    public void setProductsTotal(Double productsTotal) {
        this.productsTotal = productsTotal;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
