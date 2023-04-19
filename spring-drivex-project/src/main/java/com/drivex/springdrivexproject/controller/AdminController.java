// Package
package com.drivex.springdrivexproject.controller;

// Imports
    // Model
import com.drivex.springdrivexproject.model.Admin;
    // Service
import com.drivex.springdrivexproject.service.AdminService;
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
@RequestMapping("/api/Admin")
public class AdminController {
    // Attributes
    @Autowired
    AdminService adminService;

    // Methods-Mapping
        // Get
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> listAllAdmin() {return ResponseEntity.ok(adminService.getAll());}

        // Post
    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin)
    {
        return new ResponseEntity<>(adminService.save(admin), HttpStatus.CREATED);
    }
}
