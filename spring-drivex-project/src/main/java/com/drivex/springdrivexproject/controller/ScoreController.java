// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.model.Score;
// Service
import com.drivex.springdrivexproject.service.ScoreService;
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
@RequestMapping("/api/Score")
public class ScoreController {
    // Attributes
    @Autowired
    ScoreService scoreService;

    // Methods-Mapping
    // Get
    @GetMapping("/all")
    public ResponseEntity<List<Score>> listAllScore() {return ResponseEntity.ok(scoreService.getAll());}

    // Post
    @PostMapping("/save")
    public ResponseEntity<Score> saveScore(@RequestBody Score score)
    {
        return new ResponseEntity<>(scoreService.save(score), HttpStatus.CREATED);
    }
}
