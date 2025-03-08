package com.sampson.car_rent.service.impl;

import com.sampson.car_rent.domain.model.Reservation;
import com.sampson.car_rent.domain.repository.ReservationRepository;
import com.sampson.car_rent.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        //getReservationById(id).ifPresent(reservation -> reservationRepository.delete(reservation));
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservationChanged) {
        var reservationFound = reservationRepository.findById(id);

        if (reservationFound.isPresent()){
            reservationFound.get().setInitialDate(reservationChanged.getInitialDate());
            reservationFound.get().setFinalDate(reservationChanged.getFinalDate());
            reservationFound.get().setInsurance(reservationChanged.isInsurance());
            reservationFound.get().setClient(reservationChanged.getClient());
            reservationFound.get().setCar(reservationChanged.getCar());
        } else {
            throw new NoSuchElementException();
        }
        return reservationRepository.save(reservationChanged);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
