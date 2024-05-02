package com.cloudbees.SeatReservation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@Table(name = "booking")
@NoArgsConstructor
public class Booking extends AbstractTimestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "reservation_id", nullable = false)
    private String reservationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seat_id", nullable = false)
    private SeatingPlan seat;

    public Booking(String resId, User user, Trip trip, SeatingPlan seat) {
        this.reservationId = resId;
        this.user = user;
        this.trip = trip;
        this.seat = seat;
    }
}
