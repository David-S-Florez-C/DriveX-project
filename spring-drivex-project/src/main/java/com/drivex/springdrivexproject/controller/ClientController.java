// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.model.Client;
// Service
import com.drivex.springdrivexproject.service.ClientService;
// Spring.beans
import org.springframework.beans.factory.annotation.Autowired;
// Spring.http
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// Spring.web
import org.springframework.web.bind.annotation.*;
// Java.Utils
import java.util.List;

// Annotations

// Class
@RestController
@RequestMapping("/api/Client")
public class ClientController {
    // Attributes
    @Autowired
    ClientService clientService;

        // Methods-Mapping
    // Get
    @GetMapping("/all")
    public ResponseEntity<List<Client>> listAllClient() {return ResponseEntity.ok(clientService.getAll());}

    // Post
    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client)
    {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }
}
