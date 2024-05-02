package com.cloudbees.SeatReservation.repo;

import com.cloudbees.SeatReservation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
//    @Query("SELECT COUNT(*) FROM Booking b JOIN ")
//    public int availableSeatCount(long tripId);
}

//    SELECT COUNT(*) FROM Booking b
//        LEFT JOIN Trip t ON t.id = b.tripId
//        LEFT JOIN SeatingPlan s ON s.id = b.seatId
//        WHERE b.tripId = 1;
