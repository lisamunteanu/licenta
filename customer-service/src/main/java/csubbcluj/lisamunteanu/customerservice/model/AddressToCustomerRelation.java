package csubbcluj.lisamunteanu.customerservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer_address")
public class AddressToCustomerRelation implements Serializable {
    @EmbeddedId
    private AddressToCustomerId id = new AddressToCustomerId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerId")
    private Customer customer;

    @Column(name="type")
    private String type;

    public AddressToCustomerRelation() {
    }

    public AddressToCustomerRelation(AddressToCustomerId id, Address address, Customer customer, String type) {
        this.id = id;
        this.address = address;
        this.customer = customer;
        this.type = type;
    }

    public AddressToCustomerId getId() {
        return id;
    }

    public void setId(AddressToCustomerId id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

