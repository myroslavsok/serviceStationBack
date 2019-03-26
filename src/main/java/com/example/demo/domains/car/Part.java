package com.example.demo.domains.car;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Part {

    public Part() {}

    public Part(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cost;

    @OneToMany(mappedBy="part", cascade = CascadeType.ALL)
    private Set<BoughtPart> boughtParts;

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Set<BoughtPart> getBoughtParts() {
        return boughtParts;
    }

    public void setBoughtParts(Set<BoughtPart> boughtParts) {
        this.boughtParts = boughtParts;
    }

}
