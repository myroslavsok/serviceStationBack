package com.example.demo.domains;

import com.example.demo.domains.car.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order {

    public Order() {}

    public Order(Client client, Car car, LocalDate orderDate, String doneWork, Integer workCost, Integer partsCost, Integer totalCost) {
        this.client = client;
        this.orderDate = orderDate;
        this.doneWork = doneWork;
        this.workCost = workCost;
        this.partsCost = partsCost;
        this.totalCost = totalCost;
        this.car = car;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    LocalDate orderDate;

    String doneWork;

    Integer workCost;

    Integer partsCost;

    Integer totalCost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

}
