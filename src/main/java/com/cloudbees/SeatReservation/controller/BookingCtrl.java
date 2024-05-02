package com.cloudbees.SeatReservation.controller;

import com.cloudbees.SeatReservation.dto.BaseResponse;
import com.cloudbees.SeatReservation.dto.BookingDto;
import com.cloudbees.SeatReservation.entity.SeatingPlan;
import com.cloudbees.SeatReservation.entity.User;
import com.cloudbees.SeatReservation.repo.SeatRepo;
import com.cloudbees.SeatReservation.repo.UserRepo;
import com.cloudbees.SeatReservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingCtrl {

    @Autowired
    BookingService bookingService;

    @Autowired
    SeatRepo userRepo;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> create(@RequestBody BookingDto bookingDto) {
        BaseResponse response = bookingService.create(bookingDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<SeatingPlan>> getUser() {
        List<SeatingPlan> userList = userRepo.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
