// Package
package com.drivex.springdrivexproject.repository;

// Imports
    // Class
import com.drivex.springdrivexproject.model.Admin;
    // Spring.Data
import org.springframework.data.jpa.repository.JpaRepository;
    // Spring.stereotype
import org.springframework.stereotype.Repository;

// Annotations

// Interface
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
