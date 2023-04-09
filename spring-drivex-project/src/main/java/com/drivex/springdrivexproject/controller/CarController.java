// Package
package com.drivex.springdrivexproject.controller;

//Imports
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Annotations

// Class
@RestController
@RequestMapping("/car")
public class CarController {

    // Methods-Mapping

        // Get
    @GetMapping("/car")
    public String getCar(){
        return "This is a car";
    }
}
