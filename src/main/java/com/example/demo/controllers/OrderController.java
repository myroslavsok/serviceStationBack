package com.example.demo.controllers;

import com.example.demo.domains.Client;
import com.example.demo.domains.DTO.CarInfo;
import com.example.demo.domains.DTO.ClientInfo;
import com.example.demo.domains.DTO.DTOCars.CarPart;
import com.example.demo.domains.DTO.OrderDTO;
import com.example.demo.domains.DTO.WorkInfo;
import com.example.demo.domains.Order;
import com.example.demo.domains.car.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    private long defaultSequenceId = 1;

    private Client addClientToDB(ClientInfo clientInfo) throws Exception {
        Client client = new Client(clientInfo);
        // check for default and null
        if (client.getName().equals(unsetValue) || client.getName().equals("")) {
            return clientRepository.findById(defaultSequenceId).orElseThrow(Exception::new);
        } else {
            // check for existing
            List<Client> existingClients = clientRepository.findByNameAndPhoneNumber(client.getName(), client.getPhoneNumber());
            if (existingClients.size() < 1) {
                clientRepository.save(client);
            }
            return client;
        }
    }

    private Model addMakeAndModelForIt(CarInfo carInfo) throws Exception {
        String carMake = carInfo.getMake();
        String carModel = carInfo.getModel();
        // check for null
        if (carMake.equals(unsetValue) || carMake.isEmpty() &&
                carModel.equals(unsetValue) || carModel.isEmpty()) {
            return modelRepository.findById(defaultSequenceId).orElseThrow(Exception::new);
        } else {
            // Check for existance of make
            Make make;
            ArrayList<Make> existingMakes = makeRepository.findByMakeName(carMake);
            if (existingMakes.size() >= 1) {
                make = existingMakes.get(0);
                // Getting model of existing make
                Model model = new Model();
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
                return model;
            } else {
                // Model can't exist without make
                make = new Make(carMake);
                Model model = new Model(carModel, make);
                makeRepository.save(make);
                return modelRepository.save(model);
            }
        }

    }

    private Car addCar(CarInfo carInfo, Model model) {
        Car car = new Car(carInfo, model);
        // check for default
        if (car.getVinCode().equals(unsetValue) && car.getNumber().equals(unsetValue) &&
            car.getYear().equals(unsetValue) && car.getMiles().equals(unsetValue) &&
            car.getModel().getId() == 1) {
            return car;
        }
        return carRepository.save(car);
    }

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        // add client
        Client client = addClientToDB(orderDTO.getClientInfo());

        // add make and model
        CarInfo carInfo = orderDTO.getCarInfo();
        Model model = addMakeAndModelForIt(carInfo);

        // add car
        Car car = addCar(carInfo, model);

        // add parts

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
        List<Part> allExistingParts = partRepository.findAll();
        carParts.forEach(carPart -> {
            allExistingParts.forEach(existingPart -> {
                if (carPart.getName().equals(existingPart.getName())) {
//                    boughtPartRepository.save(new BoughtPart(existingPart, carPart.getCost(), car));
                }
            });
        });

        // add workInfo
        WorkInfo workInfo = orderDTO.getWorkInfo();
        String doneWork = workInfo.getDoneWork();
        Integer workCost = workInfo.getWorkCost();
        Integer partsCost = workInfo.getPartsCost();
        Integer totalCost = workInfo.getTotalCost();

        // add order
        LocalDate orderDate = LocalDate.parse(orderDTO.getDate());
//        Order order = new Order(client, car, orderDate, doneWork, workCost, partsCost, totalCost);
//        Order order = new Order();
//        orderRepository.save(order);

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
