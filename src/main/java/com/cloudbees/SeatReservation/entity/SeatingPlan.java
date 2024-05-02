package com.cloudbees.SeatReservation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@Table(name = "seating_plan")
public class SeatingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "section", nullable = false)
    private String section;

    public SeatingPlan(String name, String section) {
        this.name = name;
        this.section = section;
    }
}
