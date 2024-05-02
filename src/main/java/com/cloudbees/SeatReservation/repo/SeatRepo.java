package com.cloudbees.SeatReservation.repo;

import com.cloudbees.SeatReservation.entity.SeatingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<SeatingPlan, Long> {

}
