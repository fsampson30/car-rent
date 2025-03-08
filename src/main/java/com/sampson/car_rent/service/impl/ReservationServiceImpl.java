package com.sampson.car_rent.service.impl;

import com.sampson.car_rent.domain.model.Reservation;
import com.sampson.car_rent.domain.repository.ReservationRepository;
import com.sampson.car_rent.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        getReservationById(id).ifPresent(reservation -> reservationRepository.delete(reservation));
    }

    @Override
    public Reservation updateReservation(Reservation reservationChanged) {
        getReservationById(reservationChanged.getId()).ifPresent(reservation -> reservationRepository.save(reservation));
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }


}
