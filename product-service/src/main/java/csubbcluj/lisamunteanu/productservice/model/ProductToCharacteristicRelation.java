package csubbcluj.lisamunteanu.productservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_characteristic")
public class ProductToCharacteristicRelation implements Serializable {
    @EmbeddedId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_characteristic")
    private Characteristic characteristic;

    @EmbeddedId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "value")
    private String value;

    public ProductToCharacteristicRelation(Characteristic characteristic, Product product, String value) {
        this.characteristic = characteristic;
        this.product = product;
        this.value = value;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
