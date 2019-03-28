package com.example.demo.domains;

import com.example.demo.domains.DTO.WorkInfo;
import com.example.demo.domains.car.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private String status = "new";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDoneWork() {
        return doneWork;
    }

    public void setDoneWork(String doneWork) {
        this.doneWork = doneWork;
    }

    public Integer getWorkCost() {
        return workCost;
    }

    public void setWorkCost(Integer workCost) {
        this.workCost = workCost;
    }

    public Integer getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(Integer partsCost) {
        this.partsCost = partsCost;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
