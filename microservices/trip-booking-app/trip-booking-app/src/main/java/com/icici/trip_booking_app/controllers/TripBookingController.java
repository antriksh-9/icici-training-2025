package com.icici.trip_booking_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.icici.trip_booking_app.dto.TripBooking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TripBookingController {

    @PostMapping("/trip-booking")
    public TripBooking bookTrip(@RequestBody TripBooking tripBooking) {
        System.out.println("Trip booked: " + tripBooking);

        // call to trip-info service ruunning on port 9090

        // multiply booking amount by price of trip

        // return the trip booking object

        return null;
    }
    
    
}
