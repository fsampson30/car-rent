package com.sampson.car_rent.controller;

import com.sampson.car_rent.domain.model.Reservation;
import com.sampson.car_rent.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservation Controller", description = "RESTful API for managing Car Rentals.")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @Operation(summary = "Get all reservations", description = "Retrieve a list of all reservations")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a reservation by ID", description = "Retrieve a reservation with the ID informed")
    public ResponseEntity<Reservation> findReservationById(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getReservationById(id).get());
    }

    @PostMapping
    @Operation(summary = "Create a new reservation", description = "Generate new a reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }


}
