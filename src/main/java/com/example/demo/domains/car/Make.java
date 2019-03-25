package com.example.demo.domains.car;

import com.example.demo.domains.Client;
import com.example.demo.domains.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Make {

    public Make() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String makeName;

    @OneToMany(mappedBy="make", cascade = CascadeType.ALL)
    private Set<Model> models;


}
