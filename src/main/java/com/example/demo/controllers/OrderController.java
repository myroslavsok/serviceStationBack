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
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

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

    private void addCarParts(CarInfo carInfo) {
        List<CarPart> carParts = carInfo.getParts();
        carParts.forEach(carPart -> {
            List<Part> existingParts = partRepository.findAll();
            AtomicBoolean partAlreadyExists = new AtomicBoolean(false);
            existingParts.forEach(existingPart -> {
                if (carPart.getName().equals(existingPart.getName()) &&
                        carPart.getCost().equals(existingPart.getCost())) {
                    partAlreadyExists.set(true);
                }
            });
            if (!partAlreadyExists.get()) {
                partRepository.save(new Part(carPart.getName(), carPart.getCost()));
            }
        });
    }

    private void addBoughtParts(CarInfo carInfo, Car car) {
        List<CarPart> carParts = carInfo.getParts();
        List<Part> allExistingParts = partRepository.findAll();
        carParts.forEach(carPart -> {
            allExistingParts.forEach(existingPart -> {
                if (carPart.getName().equals(existingPart.getName()) &&
                        carPart.getCost().equals(existingPart.getCost())) {
                    boughtPartRepository.save(new BoughtPart(existingPart, carPart.getCost(), car));
                }
            });
        });
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
        addCarParts(carInfo);

        // Add bought parts
        addBoughtParts(carInfo, car);

        // add order
        WorkInfo workInfo = orderDTO.getWorkInfo();
        LocalDate orderDate = LocalDate.parse(orderDTO.getDate());
        orderRepository.save(new Order(client, car, orderDate, workInfo));
        return orderDTO;
    }

    @GetMapping
    public List<OrderDTO> sendAllOrders() {
        List<OrderDTO> orderDTOs = new ArrayList<>();

        List<Order> orders = orderRepository.findAll();

        orders.forEach(order -> {
            // parsing workInfo
            WorkInfo workInfo = new WorkInfo(
                    order.getDoneWork(),
                    order.getPartsCost(),
                    order.getTotalCost(),
                    order.getWorkCost()
            );

            Car car = order.getCar();

            // parsing parts for car
            List<BoughtPart> boughtParts = car.getBoughtParts();
            List<CarPart> carParts = boughtParts.stream()
                    .map(boughtPart -> new CarPart(
                            boughtPart.getPart().getName(),
                            boughtPart.getCost()))
                    .collect(Collectors.toList());

            // parsing car
            CarInfo carInfo = new CarInfo(
                    car.getNumber(),
                    car.getYear(),
                    car.getMiles(),
                    car.getVinCode(),
                    car.getModel().getMake().getMakeName(),
                    car.getModel().getModelName(),
                    carParts
            );

            // parsing client
            Client client = order.getClient();
            ClientInfo clientInfo = new ClientInfo(
                    client.getName(),
                    client.getPhoneNumber()
            );

            OrderDTO orderDTO = new OrderDTO(clientInfo, carInfo, workInfo, order.getOrderDate().toString());
            orderDTOs.add(orderDTO);
        });

        return orderDTOs;
    }

}
