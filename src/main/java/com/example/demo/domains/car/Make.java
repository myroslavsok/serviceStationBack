package com.example.demo.domains.car;

import com.example.demo.domains.Client;
import com.example.demo.domains.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Make {

    public Make() {}

    public Make(String name) {
        this.makeName = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String makeName;

    @OneToMany(mappedBy="make", cascade = CascadeType.ALL)
    private Set<Model> models;

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
