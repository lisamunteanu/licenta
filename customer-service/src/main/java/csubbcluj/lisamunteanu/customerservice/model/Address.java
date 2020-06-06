package csubbcluj.lisamunteanu.customerservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="addresses")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name="region")
    private String region;

    @Column(name="city")
    private String city;

    @Column(name="streetName")
    private String streetName;

    @Column(name="streetNumber")
    private String streetNumber;

    @Column(name="otherDetails")
    private String otherDetails;

    @Column(name="phoneNumber")
    private String phoneNumber;

    public Address() {
    }

    public Address(String region, String city, String streetName, String streetNumber, String otherDetails, String phoneNumber) {
        this.region = region;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.otherDetails = otherDetails;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
