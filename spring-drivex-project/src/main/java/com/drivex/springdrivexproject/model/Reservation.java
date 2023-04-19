// Package
package com.drivex.springdrivexproject.model;

// Imports
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Reservation")
@Entity
public class Reservation {
        // Table
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private int idReservation;

    // Columns
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "devolution_date")
    private Date devolutionDate;

    private String status = "created";

    // Foreign key
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_car", nullable = false)
    @JsonIgnoreProperties({"reservations"})
    private Car car;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_client", nullable = false)
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_score", unique = true)
    private Score score;
}
