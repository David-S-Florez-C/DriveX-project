// Package
package com.drivex.springdrivexproject.repository;

// Imports
import com.drivex.springdrivexproject.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotations

//Interface
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> { }
