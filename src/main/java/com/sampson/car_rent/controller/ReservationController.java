package com.sampson.car_rent.controller;

import com.sampson.car_rent.domain.model.Reservation;
import com.sampson.car_rent.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new reservation", description = "Generate new a reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation reservationCreated = reservationService.createReservation(reservation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reservationCreated.getId()).toUri();
        return ResponseEntity.created(location).body(reservationCreated);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a created reservation", description = "Update a reservation")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation){
        return ResponseEntity.ok(reservationService.updateReservation(id,reservation));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a created reservation", description = "Delete a reservation")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }


}
