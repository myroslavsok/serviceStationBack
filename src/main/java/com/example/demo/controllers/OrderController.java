package com.example.demo.controllers;

import com.example.demo.domains.Order;
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

    @PostMapping
    public Object addOrder(@RequestBody Object order) {
        return order;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
