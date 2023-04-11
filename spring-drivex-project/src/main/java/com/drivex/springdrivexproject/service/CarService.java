// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Java.util
import java.util.List;
import java.util.Optional;
// Model
import com.drivex.springdrivexproject.exception.ResourceNotFoundException;
import com.drivex.springdrivexproject.model.Car;
    // Spring.beans
import com.drivex.springdrivexproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
    // Spring.stereotype
import org.springframework.stereotype.Service;

// Annotations

// Class
@Service
public class CarService {
    // Attributes
    @Autowired
    CarRepository carRepository;

    // Methods

        // All Car
    public List<Car> getAll() {return carRepository.findAll();}

        // Search a Car
    public Car searchCar(Integer idCar)
    {
        return carRepository.findById(idCar).orElseThrow(ResourceNotFoundException::new);
    }

        // Save a Car
    public Car save(Car car) {return carRepository.save(car);}

        // Update a Car
    public Car updateCar(Car car, Integer idCar)
    {
        Car carProvider = carRepository.findById(idCar).orElseThrow(ResourceNotFoundException::new);
        carProvider.setBrand(car.getBrand());
        carProvider.setModel(car.getModel());
        carProvider.setCategory_id(car.getCategory_id());

        Integer idCarProvider = car.getId();
        carRepository.deleteById(idCarProvider);

        carProvider.setId(idCarProvider);

        carRepository.save(carProvider);
        return carProvider;
    }

        // Delete a Car
    public String deleteCar(Integer idCar) {
        String message = " ";
        try{
            carRepository.deleteById(idCar);
            message = "Successful request: Eliminated car";
        }catch (Exception exception){
            message = "Unsuccessful request:  An error occurred when eliminating the car";
        }
        return message;
    }
}
