package csubbcluj.lisamunteanu.customerservice.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AddressToCustomerId implements Serializable {

    private Integer addressId;
    private Integer customerId;


    public AddressToCustomerId(Integer addressId, Integer customerId) {
        this.addressId = addressId;
        this.customerId = customerId;
    }

    public AddressToCustomerId() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
