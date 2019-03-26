package com.example.demo.controllers;

import com.example.demo.domains.DTO.CarInfo;
import com.example.demo.domains.DTO.ClientInfo;
import com.example.demo.domains.DTO.DTOCars.CarPart;
import com.example.demo.domains.DTO.OrderDTO;
import com.example.demo.domains.car.Car;
import com.example.demo.domains.car.Make;
import com.example.demo.domains.car.Model;
import com.example.demo.domains.car.Part;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private BoughtPartRepository boughtPartRepository;

    private String unsetValue = "Не вказано";

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        // add client
        ClientInfo clientInfo = orderDTO.getClientInfo();
        String clientName = clientInfo.getName();
        String clientPhone = clientInfo.getPhoneNumber();
//        clientRepository.save(new Client(clientName, clientPhone));

        // add make and model
        CarInfo carInfo = orderDTO.getCarInfo();
        String carMake = carInfo.getMake();
        String carModel = carInfo.getModel();

        Make make;
        Model model;
        if (!carMake.equals(unsetValue) && !carMake.isEmpty() &&
                !carModel.equals(unsetValue) && !carModel.isEmpty()) {

            // Check for existance of make
            ArrayList<Make> existingMakes = makeRepository.findByMakeName(carMake);
            if (existingMakes.size() >= 1) {
                make = existingMakes.get(0);
                // Getting model of existing make
                boolean isModelAlreadyExists = false;
                for (Model existingModel : make.getModels()) {
                    if (existingModel.getModelName().equals(carModel)) {
                        model = existingModel;
                        isModelAlreadyExists = true;
                    }
                }
                if (!isModelAlreadyExists) {
                    model = new Model(carModel, make);
                    modelRepository.save(model);
                }
            } else {
                // Model can't exist without make
                make = new Make(carMake);
                model = new Model(carModel, make);
                makeRepository.save(make);
                modelRepository.save(model);
            }

        } else {
            // get defaults values of Make and Model
            make = makeRepository.findById((long) 1).orElseThrow(Exception::new);
            model = modelRepository.findById((long) 2).orElseThrow(Exception::new);
        }

        // add car
        String carYear = carInfo.getYear();
        String carMiles = carInfo.getMiles();
        String carNumber = carInfo.getNumber();
        String carVinCode = carInfo.getVinCode();
        Car car = new Car(carVinCode, carNumber, carYear, carMiles, make);
//        carRepository.save(car);


        // Add parts
        List<CarPart> carParts = carInfo.getParts();
        List<Part> existingParts = partRepository.findAll();
        if (existingParts.size() >= 1) {
            carParts.forEach(carPart -> {
                AtomicBoolean partAlreadyExists = new AtomicBoolean(false);
                existingParts.forEach(existingPart -> {
                    if (carPart.getName().equals(existingPart.getName())) {
                        partAlreadyExists.set(true);
                    }
                });
                if (!partAlreadyExists.get()) {
                    partRepository.save(new Part(carPart.getName(), carPart.getCost()));
                }
            });
        } else {
            carParts.forEach(carPart ->
                    partRepository.save(new Part(carPart.getName(), carPart.getCost())));
        }

        // Add bought parts
        List<Part> parts = partRepository.findAll();
        carParts.forEach(carPart -> {

//            boughtPartRepository.save()
        });

        // add workInfo
//        WorkInfo workInfo = orderDTO.getWorkInfo();

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
