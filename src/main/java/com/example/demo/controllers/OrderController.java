package com.example.demo.controllers;

import com.example.demo.domains.Client;
import com.example.demo.domains.DTO.OrderDTO;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

//    @Autowired
//    private MakeRepository makeRepository;
//
//    @Autowired
//    private ModelRepository modelRepository;

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        // add client
        String clientName = orderDTO.getClientInfo().getName();
        String clientPhone = orderDTO.getClientInfo().getPhoneNumber();
        clientRepository.save(new Client(clientName, clientPhone));


        return orderDTO;
    }

//    @PostMapping("client")
//    public Client addNewTask(@RequestBody Client client) {
//        return clientRepository.save(new Client(client.getName(), client.getPhoneNumber()));
//    }

//

//    @PostMapping("model")
//    public Model addNewModel(@RequestBody Model model) {
//        modelRepository.save(new Model());
////        Model model = new Model(car.getMake().);
////        Make make = new Make();
//    }


//    @PostMapping("car")
////    public Car addNewCar(@RequestBody Car car) {
//////        Model
////        Model model = new Model(car.getMake().);
////        Make make = new Make();
////
//////        return clientRepository.save(new Client(client.getName(), client.getPhoneNumber()));
////    }    @GetMapping
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }

}
