// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.model.Gama;
// Service
import com.drivex.springdrivexproject.service.GamaService;
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
@RequestMapping("/api/Gama")
public class GamaController {
    // Attributes
    @Autowired
    GamaService gamaService;

    // Methods-Mapping
    // Get
    @GetMapping("/all")
    public ResponseEntity<List<Gama>> listAllGama() {return ResponseEntity.ok(gamaService.getAll());}

    // Post
    @PostMapping("/save")
    public ResponseEntity<Gama> saveGama(@RequestBody Gama gama)
    {
        return new ResponseEntity<>(gamaService.save(gama), HttpStatus.CREATED);
    }
}
