// Package
package com.drivex.springdrivexproject.model;

// Imports
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Message")
@Entity
public class Message {

        // Table
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private int idMessage;

    // Columns
    @Column(name = "message_text",length = 250)
    private String messageText;

    // Foreign keys
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_car", nullable = false)
    @JsonIgnoreProperties({"messages","reservations"})
    private Car car;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_client", nullable = false)
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
}
