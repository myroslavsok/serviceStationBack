package com.example.demo.domains.DTO;

import com.example.demo.domains.DTO.DTOCars.CarPart;

import java.util.List;

public class CarInfo {

    public CarInfo() {}

    public CarInfo(String number, String year, String miles, String vinCode, String make, String model) {
        this.number = number;
        this.year = year;
        this.miles = miles;
        this.vinCode = vinCode;
        this.make = make;
        this.model = model;
    }

    public CarInfo(String number, String year, String miles, String vinCode, String make, String model, List<CarPart> parts) {
        this.number = number;
        this.year = year;
        this.miles = miles;
        this.vinCode = vinCode;
        this.make = make;
        this.model = model;
        this.parts = parts;
    }

    private String number;

    private String year;

    private String miles;

    private String vinCode;

    private String make;

    private String model;

    private List<CarPart> parts;

    public List<CarPart> getParts() {
        return parts;
    }

    public void setParts(List<CarPart> parts) {
        this.parts = parts;
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

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
