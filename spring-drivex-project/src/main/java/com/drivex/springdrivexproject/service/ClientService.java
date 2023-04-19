// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.model.Client;
import com.drivex.springdrivexproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotations

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    // Methods

    // All Client
    public List<Client> getAll() {return clientRepository.findAll();}

    // Search a Client


    // Save a Client
    public Client save(Client client) {return clientRepository.save(client);}
}
