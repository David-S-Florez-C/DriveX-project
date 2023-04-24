// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Java.util
import java.util.List;
import java.util.Optional;
// Model
import com.drivex.springdrivexproject.dbo.CarDbo;
import com.drivex.springdrivexproject.dbo.GamaDbo;
import com.drivex.springdrivexproject.exception.ResourceNotFoundException;
import com.drivex.springdrivexproject.model.Car;
    // Spring.beans
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
    // Spring.stereotype
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
        carProvider.setYear(car.getYear());
        carProvider.setGama(car.getGama());

        Integer idCarProvider = car.getIdCar();
        carRepository.deleteById(idCarProvider);

        carProvider.setIdCar(idCarProvider);

        carRepository.save(carProvider);
        return carProvider;
    }

    // Update Gama
    public boolean patchCar(CarDbo car) {
        Optional<Car> optionalCar = carRepository.findById(car.getIdCar());
        if(optionalCar.isPresent()){
            Car carProvider = optionalCar.get();

            if(car.getBrand() != null){
                carProvider.setBrand(car.getBrand());
            }
            if(car.getName() != null){
                carProvider.setName(car.getName());
            }
            if(car.getDescription() != null){
                carProvider.setDescription(car.getDescription());
            }
            if(car.getYear() != null){
                carProvider.setYear(car.getYear());
            }
            if(car.getMessages() != null){
                carProvider.setMessages(car.getMessages());
            }
            if (car.getGama() != null){
                carProvider.setGama(car.getGama());
            }
            if (car.getReservations() != null){
                carProvider.setReservations(car.getReservations());
            }
            carRepository.save(carProvider);
            return true;
        } else {
            throw new EntityNotFoundException("No se puede actualizar el objeto Example porque no existe en la base de datos.");
        }
    }

        // Delete a Car
    public boolean deleteCar(Integer idCar) {
        Optional<Car> optionalCar = carRepository.findById(idCar);

        if (optionalCar.isPresent())
        {
            Car car = optionalCar.get();
            carRepository.deleteById(car.getIdCar());
            return true;
        }else {
            return false;
        }
    }
}
