// Package
package com.drivex.springdrivexproject.repository;

// Imports
import com.drivex.springdrivexproject.model.Gama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotations

// Interface
@Repository
public interface GamaRepository extends JpaRepository<Gama, Integer> { }
