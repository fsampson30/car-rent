package com.sampson.car_rent.domain.model;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String brand;
    String model;
    String fabricationYear;

    public Car() {
    }

    public Car(Long id, String brand, String model, String fabricationYear) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fabricationYear = fabricationYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}
