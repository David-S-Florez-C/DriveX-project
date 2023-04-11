// Package
package com.drivex.springdrivexproject.repository;

// Imports
    // Spring.JPA
import org.springframework.data.jpa.repository.JpaRepository;
    // Spring.stereotype
import org.springframework.stereotype.Repository;
    // Model
import com.drivex.springdrivexproject.model.Car;

// Annotations

// Interface
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> { }
