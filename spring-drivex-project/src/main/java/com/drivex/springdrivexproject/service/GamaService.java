// Package
package com.drivex.springdrivexproject.service;

// Imports
// Spring.stereotype
import com.drivex.springdrivexproject.model.Admin;
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
