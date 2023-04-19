// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.model.Score;
import com.drivex.springdrivexproject.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotations

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    // Methods

    // All Score
    public List<Score> getAll() {return scoreRepository.findAll();}

    // Search a Score


    // Save a Score
    public Score save(Score score) {return scoreRepository.save(score);}
}
