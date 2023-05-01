// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.dbo.ScoreDbo;
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

    // Patch but for the challenge is Update
    @PutMapping("/update")
    public ResponseEntity<Void> patchScore(@RequestBody ScoreDbo score)
    {
        boolean patched = scoreService.patchScore(score);

        if(patched){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Integer id) // You could write "String" instead of "Void"
    {
        boolean deleted = scoreService.deleteScore(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
