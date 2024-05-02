package com.cloudbees.SeatReservation.repo;

import com.cloudbees.SeatReservation.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepo extends JpaRepository<Trip, Long> {
}
