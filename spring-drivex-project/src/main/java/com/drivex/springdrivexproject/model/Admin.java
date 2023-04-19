// Package
package com.drivex.springdrivexproject.model;

// Imports
    // Lombok
import lombok.*;
    // Javax.persistence
import javax.persistence.*;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Admin")
@Entity
public class Admin {

        // Columns
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    private  byte age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private int idAdmin;
}
