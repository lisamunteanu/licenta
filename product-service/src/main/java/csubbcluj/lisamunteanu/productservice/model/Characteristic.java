package csubbcluj.lisamunteanu.productservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "characteristics")
public class Characteristic implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Characteristic(String name) {
        this.name = name;
    }

    public Characteristic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
