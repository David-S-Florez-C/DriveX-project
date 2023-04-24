// Package
package com.drivex.springdrivexproject.dbo;

// Imports
import javax.persistence.*;

import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.model.Client;
import com.drivex.springdrivexproject.model.Score;
import lombok.*;

import java.util.Date;

// Annotations
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

// Class
public class ReservationDbo {
    private Date startDate;
    private Date devolutionDate;
    private String status;
    private Score score;
    private Car car;
    private Client client;
    private int idReservation;
}
