// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.dbo.ClientDbo;
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.model.Client;
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    // Update Client
    public boolean patchClient(ClientDbo client) {
        Optional<Client> optionalClient = clientRepository.findById(client.getIdClient());
        if(optionalClient.isPresent()){
            Client clientProvider = optionalClient.get();

            if(client.getAge() != null){
                client.setAge(client.getAge());
            }
            if(client.getName() != null){
                client.setName(client.getName());
            }
            if(client.getEmail() != null){
                client.setEmail(client.getEmail());
            }
            if(client.getPassword() != null){
                client.setPassword(client.getPassword());
            }
            if(client.getReservations() != null){
                client.setReservations(client.getReservations());
            }
            if(client.getMessages() != null){
                client.setMessages(client.getMessages());
            }
            clientRepository.save(clientProvider);
            return true;
        } else {
            throw new EntityNotFoundException("No se puede actualizar el objeto Example porque no existe en la base de datos.");
        }
    }

        // Delete a Client
    public boolean deleteClient(Integer idClient) {
        Optional<Client> optionalClient = clientRepository.findById(idClient);

        if (optionalClient.isPresent())
        {
            Client client = optionalClient.get();
            clientRepository.deleteById(client.getIdClient());
            return true;
        }else {
            return false;
        }
    }
}
