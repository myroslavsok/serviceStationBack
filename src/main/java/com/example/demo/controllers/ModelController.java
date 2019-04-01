package com.example.demo.controllers;

import com.example.demo.domains.DTO.DTOCars.CarMake;
import com.example.demo.domains.DTO.DTOCars.CarModel;
import com.example.demo.domains.DTO.OrderDTO;
import com.example.demo.domains.car.Car;
import com.example.demo.domains.car.Make;
import com.example.demo.domains.car.Model;
import com.example.demo.repositories.MakeRepository;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("models")
@CrossOrigin
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private MakeRepository makeRepository;

    @GetMapping
    private List<Make> getModels() {
        return makeRepository.findAll();
    }

}
