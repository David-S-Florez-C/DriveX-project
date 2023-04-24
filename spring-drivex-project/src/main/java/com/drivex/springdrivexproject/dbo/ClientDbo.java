// Package
package com.drivex.springdrivexproject.dbo;

    // Imports
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
public class ClientDbo {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private List<Message> messages;
    private List<Reservation> reservations;
    private int idClient;
}
