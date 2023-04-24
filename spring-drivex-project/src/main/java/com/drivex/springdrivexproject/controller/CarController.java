// Package
package com.drivex.springdrivexproject.controller;

// Imports
    // Jva.util
import java.util.List;
    // Model.Service
import com.drivex.springdrivexproject.dbo.CarDbo;
import com.drivex.springdrivexproject.dbo.GamaDbo;
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

    // Patch but for the challenge is Update
    @PatchMapping("/update")
    public ResponseEntity<Void> patchCar(@RequestBody CarDbo car)
    {
        boolean patched = carService.patchCar(car);

        if(patched){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

        // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) // You could write "String" instead of "Void"
    {
        boolean deleted = carService.deleteCar(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
