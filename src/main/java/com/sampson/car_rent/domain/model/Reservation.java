package com.sampson.car_rent.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    LocalDateTime initialDate;
    LocalDateTime finalDate;
    boolean insurance;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Client client;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Car car;

    public Reservation() {
    }

    public Reservation(Long id, LocalDateTime initialDate, LocalDateTime finalDate, boolean insurance, Client client, Car car) {
        this.id = id;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.insurance = insurance;
        this.client = client;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDateTime getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
