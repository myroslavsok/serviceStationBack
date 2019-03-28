package com.example.demo.domains.DTO.DTOCars;

public class CarPart {

    public CarPart() {}

    public CarPart(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    private String name;

    private String cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
