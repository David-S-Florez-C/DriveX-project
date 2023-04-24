// Package
package com.drivex.springdrivexproject.service;

// Imports
// Spring.stereotype
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.exception.ResourceNotFoundException;
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

// Annotations

@Service
public class GamaService {

    @Autowired
    GamaRepository gamaRepository;

    // Methods

    // All Gama
    public List<Gama> getAll() {return gamaRepository.findAll();}

    // Search a Gama


    // Save a Gama
    public Gama save(Gama gama) {return gamaRepository.save(gama);}

        // Update Gama
    public boolean patchGama(GamaDbo gama) {
        Optional<Gama> optionalGama = gamaRepository.findById(gama.getIdGama());
        if(optionalGama.isPresent()){
            Gama gamaProvider = optionalGama.get();

            if(gama.getName() != null){
                gamaProvider.setName(gama.getName());
            }
            if(gama.getDescription() != null){
                gamaProvider.setDescription(gama.getDescription());
            }
            if(gama.getCars() != null){
                gamaProvider.setCars(gama.getCars());
            }
            gamaRepository.save(gamaProvider);
            return true;
        } else {
            throw new EntityNotFoundException("No se puede actualizar el objeto Example porque no existe en la base de datos.");
        }
    }

        // Delete a Gama
    public boolean deleteGama(Integer idGama) {
        Optional<Gama> optionalGama = gamaRepository.findById(idGama);

        if (optionalGama.isPresent())
        {
            Gama gama = optionalGama.get();
            gamaRepository.deleteById(gama.getIdGama());
            return true;
        }else {
            return false;
        }
    }
}
