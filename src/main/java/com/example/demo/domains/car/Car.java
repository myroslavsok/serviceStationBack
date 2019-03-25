//package com.example.demo.domains.car;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//
//@Entity
//public class Car {
//
//    public Car() {}
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String vinCode;
//
//    private String number;
//
//    private Integer year;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "make_id")
//    @JsonIgnore
//    private Make make;
//
//    public String getVinCode() {
//        return vinCode;
//    }
//
//    public void setVinCode(String vinCode) {
//        this.vinCode = vinCode;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public Integer getYear() {
//        return year;
//    }
//
//    public void setYear(Integer year) {
//        this.year = year;
//    }
//
//    public Make getMake() {
//        return make;
//    }
//
//    public void setMake(Make make) {
//        this.make = make;
//    }
//
//}
