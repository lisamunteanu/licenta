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

    @OneToOne
    @JoinColumn(name = "idCart")
    private Cart cart;

    public Order() {
    }

    public Order(Integer userId, LocalDateTime date, String deliveryMode, String paymentMode, Cart cart) {
        this.userId = userId;
        this.date = date;
        this.deliveryMode = deliveryMode;
        this.paymentMode = paymentMode;
        this.cart = cart;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
