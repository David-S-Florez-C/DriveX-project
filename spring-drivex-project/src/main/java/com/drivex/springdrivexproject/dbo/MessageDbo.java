// Package
package com.drivex.springdrivexproject.dbo;

// Imports
    // Lombok
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.model.Client;
import lombok.*;


// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
public class MessageDbo {

    private String messageText;

    private Car car;

    private Client client;
    private int idMessage;
}
