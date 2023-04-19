// Package
package com.drivex.springdrivexproject.dbo;

// Imports
import com.drivex.springdrivexproject.model.Reservation;
import lombok.*;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
public class ScoreDbo {
    private float value;
    private int idScore;
    private Reservation reservation;
}

