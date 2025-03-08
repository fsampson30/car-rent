package com.sampson.car_rent.service;

import com.sampson.car_rent.domain.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation createReservation(Reservation reservation);

    void deleteReservation(Long id);

    Reservation updateReservation(Long id, Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);
}
