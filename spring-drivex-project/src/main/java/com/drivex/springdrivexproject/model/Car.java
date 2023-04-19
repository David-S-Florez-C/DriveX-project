// Package
package com.drivex.springdrivexproject.model;

// Imports
    // Lombok
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
    // Javax.persistence
import javax.persistence.*;
import java.util.List;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Car")
@Entity
public class Car {
        // Table
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private int idCar;

    //Columns
    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;

    @Column(length = 4, name = "year_car")
    private int year;

    @Column(length = 250)
    private String description;

    // Foreign keys
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_gama", nullable = false)
    @JsonIgnoreProperties("cars")
    private Gama gama;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "car")
    private List<Reservation> reservations;
}
