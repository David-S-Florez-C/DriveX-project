// Package
package com.drivex.springdrivexproject.repository;

// Imports
import com.drivex.springdrivexproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotations

//Interface
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> { }
