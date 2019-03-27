package com.example.demo.domains;


import com.example.demo.domains.DTO.ClientInfo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    public Client() {}

    public Client(ClientInfo clientInfo) {
        this.name = clientInfo.getName();
        this.phoneNumber = clientInfo.getPhoneNumber();
    }

    public Client(Long id, ClientInfo clientInfo) {
        this.id = id;
        this.name = clientInfo.getName();
        this.phoneNumber = clientInfo.getPhoneNumber();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String phoneNumber;

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
