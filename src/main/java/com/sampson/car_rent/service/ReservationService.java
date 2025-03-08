package com.sampson.car_rent.service;

import com.sampson.car_rent.domain.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation createReservation(Reservation reservation);

    void deleteReservation(Long id);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(Long id);
}
