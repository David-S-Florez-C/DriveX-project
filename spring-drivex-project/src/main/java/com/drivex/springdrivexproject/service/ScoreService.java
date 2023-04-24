// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.dbo.ScoreDbo;
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.model.Score;
import com.drivex.springdrivexproject.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    // Update Gama
    public boolean patchScore(ScoreDbo score) {
        Optional<Score> optionalScore = scoreRepository.findById(score.getIdScore());
        if(optionalScore.isPresent()){
            Score scoreProvider = optionalScore.get();

            if(score.getStars() != null){
                scoreProvider.setStars(score.getStars());
            }
            scoreRepository.save(scoreProvider);
            return true;
        } else {
            throw new EntityNotFoundException("No se puede actualizar el objeto Example porque no existe en la base de datos.");
        }
    }

    // Delete a Score
    public boolean deleteScore(Integer idScore) {
        Optional<Score> optionalScore = scoreRepository.findById(idScore);

        if (optionalScore.isPresent())
        {
            Score score = optionalScore.get();
            scoreRepository.deleteById(score.getIdScore());
            return true;
        }else {
            return false;
        }
    }
}
