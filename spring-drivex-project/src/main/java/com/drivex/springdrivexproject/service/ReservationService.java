// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.dbo.ReservationDbo;
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.model.Reservation;
import com.drivex.springdrivexproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    // Update Gama
    public boolean patchReservation(ReservationDbo reservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservation.getIdReservation());
        if(optionalReservation.isPresent()){
            Reservation reservationProvider = optionalReservation.get();

            if (reservation.getStartDate() != null){
                reservationProvider.setStartDate(reservation.getStartDate());
            }
            if (reservation.getDevolutionDate() != null){
                reservationProvider.setDevolutionDate(reservation.getDevolutionDate());
            }
            if (reservation.getScore() != null){
                reservationProvider.setScore(reservation.getScore());
            }
            if (reservation.getStatus() != null){
                reservationProvider.setStatus(reservation.getStatus());
            }
            if (reservation.getCar() != null){
                reservationProvider.setCar(reservation.getCar());
            }
            if (reservation.getClient() != null){
                reservationProvider.setClient(reservation.getClient());
            }
            reservationRepository.save(reservationProvider);
            return true;
        } else {
            throw new EntityNotFoundException("No se puede actualizar el objeto Example porque no existe en la base de datos.");
        }
    }

    // Delete a Reservation
    public boolean deleteReservation(Integer idReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(idReservation);

        if (optionalReservation.isPresent())
        {
            Reservation reservation = optionalReservation.get();
            reservationRepository.deleteById(reservation.getIdReservation());
            return true;
        }else {
            return false;
        }
    }
}
