// Package
package com.drivex.springdrivexproject.repository;

// Imports
import com.drivex.springdrivexproject.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotations

// Interface
@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> { }
