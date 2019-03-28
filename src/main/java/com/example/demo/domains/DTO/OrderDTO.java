package com.example.demo.domains.DTO;


import com.example.demo.domains.Client;
import com.example.demo.domains.DTO.DTOCars.CarPart;
import com.example.demo.domains.Order;
import com.example.demo.domains.car.BoughtPart;
import com.example.demo.domains.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    static public class Transfer {
        public static List<OrderDTO> orderstoOrderDTOs(List<Order> orders) {
            List<OrderDTO> orderDTOs = new ArrayList<>();

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

                OrderDTO orderDTO = new OrderDTO(
                        clientInfo,
                        carInfo, workInfo,
                        order.getOrderDate().toString(),
                        order.getStatus(),
                        order.getId()
                );
                orderDTOs.add(orderDTO);
            });
            return orderDTOs;
        }
    }

    public OrderDTO() {}

    public OrderDTO(ClientInfo clientInfo, CarInfo carInfo, WorkInfo workInfo, String date) {
        this.clientInfo = clientInfo;
        this.carInfo = carInfo;
        this.workInfo = workInfo;
        this.date = date;
    }

    public OrderDTO(
            ClientInfo clientInfo,
            CarInfo carInfo,
            WorkInfo workInfo,
            String date,
            String status,
            Long key) {
        this.clientInfo = clientInfo;
        this.carInfo = carInfo;
        this.workInfo = workInfo;
        this.date = date;
        this.key = key;
        this.status = status;
    }

    private ClientInfo clientInfo;

    private CarInfo carInfo;

    private WorkInfo workInfo;

    private String date;

    private Long key;

    private String status;

    public String getDate() {
        return date;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WorkInfo getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(WorkInfo workInfo) {
        this.workInfo = workInfo;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

}
