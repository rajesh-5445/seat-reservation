package com.cloudbees.SeatReservation.service;

import com.cloudbees.SeatReservation.dto.BaseResponse;
import com.cloudbees.SeatReservation.dto.BookingDto;
import com.cloudbees.SeatReservation.entity.Booking;
import com.cloudbees.SeatReservation.entity.SeatingPlan;
import com.cloudbees.SeatReservation.entity.Trip;
import com.cloudbees.SeatReservation.entity.User;
import com.cloudbees.SeatReservation.repo.BookingRepo;
import com.cloudbees.SeatReservation.repo.SeatRepo;
import com.cloudbees.SeatReservation.repo.TripRepo;
import com.cloudbees.SeatReservation.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TripRepo tripRepo;

    @Autowired
    SeatRepo seatRepo;

    @Transactional
    public BaseResponse create(BookingDto bookingDto) {
        BaseResponse response;
        AtomicInteger createdBookingCount = new AtomicInteger();

        //TODO: check available seat count before creating new reservation

        try {
            Arrays.stream(bookingDto.getSeatId()).forEach(s -> {
                Optional<User> user = userRepo.findById(bookingDto.getUserId());
                Optional<Trip> trip = tripRepo.findById(bookingDto.getTripId());
                Optional<SeatingPlan> seat = seatRepo.findById(s);

                if (user.isPresent() && trip.isPresent() && seat.isPresent()) {
                    String resId = RandomStringUtils.randomAlphanumeric(6);
                    Booking booking = new Booking(resId, user.get(), trip.get(), seat.get());
                    Booking newBooking = bookingRepo.save(booking);
                    if (Objects.nonNull(newBooking)) {
                        createdBookingCount.addAndGet(1);
                    }
                }
            });

            if (bookingDto.getSeatId().length == createdBookingCount.get()) {
                response = new BaseResponse(true, null);
            } else {
                throw new Exception("OOPS! Something unexpected has occurred.");
            }
        } catch (Exception ex) {
            response = new BaseResponse(false, ex.getLocalizedMessage());
        }
        return response;
    }
}
