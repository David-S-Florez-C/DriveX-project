// Package
package com.drivex.springdrivexproject.controller;

// Imports
    // Jva.util
import java.util.List;
    // Model.Service
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.service.CarService;
    // Spring.beans
import org.springframework.beans.factory.annotation.Autowired;
    // Spring.web
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Annotations

// Class
@RestController
@RequestMapping("/api/Car")
public class CarController {
    // Attributes
    @Autowired
    CarService carService;

    // Methods-Mapping
        // Get
    @GetMapping("/all")
    public ResponseEntity<List<Car>> listAllCar()
    {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Car> searchCarById(@PathVariable("id") Integer idCar)
    {
        return new ResponseEntity<>(carService.searchCar(idCar), HttpStatus.OK);
    }

        // Post
    @PostMapping("/save")
    public ResponseEntity<Car> saveCar(@RequestBody Car car)
    {
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

        // Put
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Integer idCar, @RequestBody Car car)
    {
        return new ResponseEntity<>(carService.updateCar(car, idCar), HttpStatus.OK);
    }

        // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer idCar)
    {
        ResponseEntity<String> response = null;
        if(carService.deleteCar(idCar) != null)
        {
            response = ResponseEntity.ok("Car with ID: " + idCar + ", correctly Delete");
        } else
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fatal Error");
        }
        return response;
    }
}
