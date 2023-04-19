// Package
package com.drivex.springdrivexproject.dbo;

// Imports
    // Lombok
import com.drivex.springdrivexproject.model.Gama;
import lombok.*;


// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
public class CarDbo {

    private String name;
    private String brand;
    private int year;
    private String description;
    private Gama gama;

    private int idCar;
}
