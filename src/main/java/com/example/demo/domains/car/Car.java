package com.example.demo.domains.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Car {

    public Car() {}

    public Car(String vinCode, String number, String year, String miles, Make make) {
        this.vinCode = vinCode;
        this.number = number;
        this.year = year;
        this.miles = miles;
        this.make = make;
    }

    public Car(Long id, String vinCode, String number, String year, String miles, Make make) {
        this.id = id;
        this.vinCode = vinCode;
        this.number = number;
        this.year = year;
        this.miles = miles;
        this.make = make;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vinCode;

    private String number;

    private String year;

    private String miles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "make_id")
    @JsonIgnore
    private Make make;

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

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

}
