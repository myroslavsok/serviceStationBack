package com.example.demo.domains.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Model {

    public Model() {}

    public Model(String name, Make make) {
        this.modelName = name;
        this.make = make;
    }

    public Model(Long id, String name, Make make) {
        this.id = id;
        this.modelName = name;
        this.make = make;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "make_id")
    @JsonIgnore
    private Make make;

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
