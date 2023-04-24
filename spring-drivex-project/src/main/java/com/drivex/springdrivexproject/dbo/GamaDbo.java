// Package
package com.drivex.springdrivexproject.dbo;

// Imports
    // Lombok
import com.drivex.springdrivexproject.model.Car;
import lombok.*;

import java.util.List;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
public class GamaDbo {
    private String name;
    private String description;
    private int idGama;
    private List<Car> cars;
}
