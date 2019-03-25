package com.example.demo.domains.DTO.DTOCars;

public class CarModel {

    public CarModel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }

    private String name;

    private CarMake carMake;

}
