package com.example.demo.domains.DTO;

import com.example.demo.domains.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;


public class OrderDTO {

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
            String orderStatus,
            Long orderKey) {
        this.clientInfo = clientInfo;
        this.carInfo = carInfo;
        this.workInfo = workInfo;
        this.date = date;
        this.orderKey = orderKey;
        this.orderStatus = orderStatus;
    }

    private ClientInfo clientInfo;

    private CarInfo carInfo;

    private WorkInfo workInfo;

    private String date;

    private Long orderKey;

    private String orderStatus;

    public String getDate() {
        return date;
    }

    public Long getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(Long orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
