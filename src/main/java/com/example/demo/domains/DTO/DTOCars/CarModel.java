package com.example.demo.domains.DTO.DTOCars;

public class CarModel {

    public CarModel() {}

    public CarModel(String modelName, CarMake carMake) {
        this.modelName = modelName;
        this.carMake = carMake;
    }

    private String modelName;

    private CarMake carMake;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }



}
