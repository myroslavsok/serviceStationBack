package com.example.demo.domains.DTO;

import com.example.demo.domains.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;


public class OrderDTO {

    public OrderDTO() {}

    ClientInfo clientInfo;

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

}
