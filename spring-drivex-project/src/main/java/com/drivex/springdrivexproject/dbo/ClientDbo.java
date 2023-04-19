// Package
package com.drivex.springdrivexproject.dbo;

    // Imports
import lombok.*;


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
    private byte age;
    private int idClient;
}
