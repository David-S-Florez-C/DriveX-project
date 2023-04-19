// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.model.Reservation;
// Service
import com.drivex.springdrivexproject.service.ReservationService;
// Spring.beans
import org.springframework.beans.factory.annotation.Autowired;
// Spring.http
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// Spring.web
import org.springframework.web.bind.annotation.*;
// Java.Utils
import java.util.List;

// Annotations

// Class
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    // Attributes
    @Autowired
    ReservationService reservationService;

    // Methods-Mapping
    // Get
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> listAllReservation() {return ResponseEntity.ok(reservationService.getAll());}

    // Post
    @PostMapping("/save")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation)
    {
        return new ResponseEntity<>(reservationService.save(reservation), HttpStatus.CREATED);
    }
}
