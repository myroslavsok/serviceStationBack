package com.example.demo.controllers;

import com.example.demo.domains.Client;
import com.example.demo.domains.Order;
import com.example.demo.domains.car.Car;
import com.example.demo.domains.car.Make;
import com.example.demo.domains.car.Model;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MakeRepository;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MakeRepository makeRepository;

    @Autowired
    private ModelRepository modelRepository;

//    @PostMapping
//    public Object addOrder(@RequestBody Object order) {
//        return order;
//    }

    @PostMapping("client")
    public Client addNewTask(@RequestBody Client client) {
        return clientRepository.save(new Client(client.getName(), client.getPhoneNumber()));
    }

    @PostMapping("car")
    public Car addNewCar(@RequestBody Car car) {
//        Model
        Model model = new Model(car.getMake().);
        Make make = new Make();

//        return clientRepository.save(new Client(client.getName(), client.getPhoneNumber()));
    }

    @PostMapping("model")
    public Model addNewModel(@RequestBody Model model) {
        modelRepository.save(new Model());
//        Model model = new Model(car.getMake().);
//        Make make = new Make();
    }


    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
