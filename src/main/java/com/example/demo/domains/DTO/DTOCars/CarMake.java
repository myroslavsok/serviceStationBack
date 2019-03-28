package com.example.demo.domains.DTO.DTOCars;

public class CarMake {

    public CarMake() {}

    public CarMake(String makeName) {
        this.makeName = makeName;
    }

    private String makeName;

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

}
