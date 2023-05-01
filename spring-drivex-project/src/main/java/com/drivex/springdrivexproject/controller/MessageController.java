// Package
package com.drivex.springdrivexproject.controller;

// Imports
// Model
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.dbo.MessageDbo;
import com.drivex.springdrivexproject.model.Message;
// Service
import com.drivex.springdrivexproject.service.MessageService;
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
@RequestMapping("/api/Message")
public class MessageController {
    // Attributes
    @Autowired
    MessageService messageService;

    // Methods-Mapping
        // Get
    @GetMapping("/all")
    public ResponseEntity<List<Message>> listAllMessage() {return ResponseEntity.ok(messageService.getAll());}

        // Post
    @PostMapping("/save")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message)
    {
        return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
    }

    // Patch but for the challenge is Update
    @PutMapping("/update")
    public ResponseEntity<Void> patchMessage(@RequestBody MessageDbo message)
    {
        boolean patched = messageService.patchMessage(message);

        if(patched){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

        // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer id) // You could write "String" instead of "Void"
    {
        boolean deleted = messageService.deleteMessage(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
