// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.model.Reservation;
import com.drivex.springdrivexproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotations

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    // Methods

    // All Reservation
    public List<Reservation> getAll() {return reservationRepository.findAll();}

    // Search a Reservation


    // Save a Reservation
    public Reservation save(Reservation reservation) {return reservationRepository.save(reservation);}
}
