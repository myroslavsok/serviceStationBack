package com.example.demo.domains;

import com.example.demo.domains.DTO.WorkInfo;
import com.example.demo.domains.car.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name="\"Order\"")
@Table(name="OrderClient")
public class Order {

    public Order() {}

    public Order(Client client, Car car, LocalDate orderDate, WorkInfo workInfo) {
        this.client = client;
        this.car = car;
        this.orderDate = orderDate;
        this.doneWork = workInfo.getDoneWork();
        this.workCost = workInfo.getWorkCost();
        this.partsCost = workInfo.getPartsCost();
        this.totalCost = workInfo.getTotalCost();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    @Column(columnDefinition="TEXT")
    private String doneWork;

    private Integer workCost;

    private Integer partsCost;

    private Integer totalCost;

    private String status = "New";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;


}
