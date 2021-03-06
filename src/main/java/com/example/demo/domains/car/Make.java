package com.example.demo.domains.car;

import com.example.demo.domains.Client;
import com.example.demo.domains.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Make {

    public Make() {}

    public Make(String name) {
        this.makeName = name;
    }

    public Make(Long id, String name) {
        this.id = id;
        this.makeName = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String makeName;

    @OneToMany(mappedBy="make", cascade = CascadeType.ALL)
    private Set<Model> models;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

}
