// Package
package com.drivex.springdrivexproject.model;

// Imports
    // Lombok
import lombok.*;
    // Javax.persistence
import javax.persistence.*;
    // Java.Util
import java.util.List;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Gama")
@Entity
public class Gama {
        // Table
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private int idGama;

    // Columns
    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String description;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "gama")
    private List<Car> cars;
}
