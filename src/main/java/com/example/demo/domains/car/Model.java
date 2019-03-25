package com.example.demo.domains.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Model {

    public Model() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String modelName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "make_id")
    @JsonIgnore
    private Make make;

}
