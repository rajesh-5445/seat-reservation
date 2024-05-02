package com.cloudbees.SeatReservation.config;

import com.cloudbees.SeatReservation.entity.SeatingPlan;
import com.cloudbees.SeatReservation.entity.User;
import com.cloudbees.SeatReservation.repo.SeatRepo;
import com.cloudbees.SeatReservation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        userRepo.save(new User("Alln", "sadsa", "asd@fsd.com"));
    }
}
