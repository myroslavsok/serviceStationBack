package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order {

    public Order() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    LocalDate orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;


}
