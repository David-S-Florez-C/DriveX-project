// Package
package com.drivex.springdrivexproject.model;

// Imports
import lombok.*;

import javax.persistence.*;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
@Table(name = "Score")
@Entity
public class Score {
        // Table
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    private int idScore;

    // Columns
    private int stars;
}
