// Package
package com.drivex.springdrivexproject.model;

// Imports
import lombok.*;
import javax.persistence.*;
import java.util.List;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Client")
@Entity
public class Client {
        // Table
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;
    // Columns
    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column(length = 250)
    private String name;

    @Column(length = 3)
    private byte age;

    // Foreign keys
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "client")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "client")
    private List<Reservation> reservations;
}
