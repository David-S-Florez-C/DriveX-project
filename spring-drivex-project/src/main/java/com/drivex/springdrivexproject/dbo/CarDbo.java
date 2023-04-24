// Package
package com.drivex.springdrivexproject.dbo;

// Imports
    // Lombok
import com.drivex.springdrivexproject.model.Gama;
import com.drivex.springdrivexproject.model.Message;
import com.drivex.springdrivexproject.model.Reservation;
import lombok.*;

import java.util.List;


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
    private Integer year;
    private String description;
    private Gama gama;
    private List<Message> messages;
    private List<Reservation> reservations;

    private int idCar;
}
