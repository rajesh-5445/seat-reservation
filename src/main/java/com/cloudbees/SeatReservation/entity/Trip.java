package com.cloudbees.SeatReservation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@Table(name = "trip")
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "departure_at", nullable = false)
    private String departureAt;

    @Column(name = "arrival_at", nullable = false)
    private String arrivalAt;

    @Column(name = "fair", nullable = false)
    private float fair;
}
