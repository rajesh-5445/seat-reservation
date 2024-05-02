package com.cloudbees.SeatReservation.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {
    private String reservationId;
    @Positive
    @Min(value = 1)
    private long userId;
    @Positive
    @Min(value = 1)
    private long tripId;
    @Size(min = 1, max = 5, message = "Can't book more than 5 seat at once")
    private long[] seatId;
    private BookingDto active;
}
