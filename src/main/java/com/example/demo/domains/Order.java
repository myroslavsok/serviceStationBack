package com.example.demo.domains;

import com.example.demo.domains.car.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="\"Order\"")
public class Order {

    public Order() {}

    public Order(Client client, Car car, LocalDate orderDate, String doneWork, Integer workCost, Integer partsCost, Integer totalCost) {
        this.client = client;
        this.car = car;
        this.orderDate = orderDate;
        this.doneWork = doneWork;
        this.workCost = workCost;
        this.partsCost = partsCost;
        this.totalCost = totalCost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate orderDate;

    @Column(columnDefinition="TEXT")
    private String doneWork;

    private Integer workCost;

    private Integer partsCost;

    private Integer totalCost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;


}
