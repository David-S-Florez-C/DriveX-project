// Package
package com.drivex.springdrivexproject.dbo;

// Imports
    // Lombok
import lombok.*;


// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class

public class AdminDbo {
    private String email;
    private String password;
    private  byte age;
    private int idAdmin;
}
