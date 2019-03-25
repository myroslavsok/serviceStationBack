package com.example.demo.controllers;

import com.example.demo.domains.Client;
import com.example.demo.domains.DTO.CarInfo;
import com.example.demo.domains.DTO.ClientInfo;
import com.example.demo.domains.DTO.OrderDTO;
import com.example.demo.domains.car.Make;
import com.example.demo.domains.car.Model;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MakeRepository;
import com.example.demo.repositories.ModelRepository;
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

    @Autowired
    private MakeRepository makeRepository;

    @Autowired
    private ModelRepository modelRepository;

    private String unsetValue = "Не вказано";

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        // add client
        ClientInfo clientInfo = orderDTO.getClientInfo();
        String clientName = clientInfo.getName();
        String clientPhone = clientInfo.getPhoneNumber();
//        clientRepository.save(new Client(clientName, clientPhone));

        // add make and model
        CarInfo carInfo = orderDTO.getCarInfo();
        String carMake = carInfo.getMake();
        String carModel = carInfo.getModel();
        if (!carMake.equals(unsetValue) && !carMake.isEmpty() &&
                !carModel.equals(unsetValue) && !carModel.isEmpty()) {
            Make make = new Make(carMake);
            makeRepository.save(make);
            Model model = new Model(carModel, make);
            modelRepository.save(model);
        }


        // add car
        String carYear = carInfo.getYear();
        String carMiles = carInfo.getMiles();
        String carNumber = carInfo.getNumber();
        String carVinCode = carInfo.getVinCode();





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
