// Package
package com.drivex.springdrivexproject.model;

// Imports
    // Lombok
import lombok.*;
    // Javax.persistence
import javax.persistence.Entity;
import javax.persistence.Id;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Entity
public class Car {

        // Columns
    private String brand;
    private int model;
    private int category_id;
    @Id
    private int id;
}
