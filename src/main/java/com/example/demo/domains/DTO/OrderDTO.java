package com.example.demo.domains.DTO;


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
            String status,
            Long key) {
        this.clientInfo = clientInfo;
        this.carInfo = carInfo; c
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
