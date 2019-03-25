package com.example.demo.domains.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Car {

    public Car() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vinCode;

    private String number;

    private Integer year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "make_id")
    @JsonIgnore
    private Make make;

}
