package com.example.demo.domains.car;

import com.example.demo.domains.DTO.CarInfo;
import com.example.demo.domains.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Car {

    public Car() {}

    public Car(Long id, CarInfo carInfo, Model model) {
        this.id = id;
        this.vinCode = carInfo.getVinCode();
        this.number = carInfo.getNumber();
        this.year = carInfo.getYear();
        this.miles = carInfo.getMiles();
        this.model = model;
    }

    public Car(CarInfo carInfo, Model model) {
        this.vinCode = carInfo.getVinCode();
        this.number = carInfo.getNumber();
        this.year = carInfo.getYear();
        this.miles = carInfo.getMiles();
        this.model = model;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vinCode;

    private String number;

    private String year;

    private String miles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    @JsonIgnore
    private Model model;

    @OneToMany(mappedBy="car", cascade = CascadeType.ALL)
    private Set<BoughtPart> boughtParts;

    @OneToMany(mappedBy="car", cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BoughtPart> getBoughtParts() {
        return boughtParts;
    }

    public void setBoughtParts(Set<BoughtPart> boughtParts) {
        this.boughtParts = boughtParts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

}
