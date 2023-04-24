// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.dbo.ClientDbo;
import com.drivex.springdrivexproject.dbo.GamaDbo;
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

    // Patch but for the challenge is Update
    @PatchMapping("/update")
    public ResponseEntity<Void> patchClient(@RequestBody ClientDbo client)
    {
        boolean patched = clientService.patchClient(client);

        if(patched){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

        // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) // You could write "String" instead of "Void"
    {
        boolean deleted = clientService.deleteClient(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
