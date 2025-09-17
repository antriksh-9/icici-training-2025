package com.icici.trip_booking_app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.icici.trip_booking_app.dto.Trip;
import com.icici.trip_booking_app.dto.TripBooking;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
public class TripBookingController {

    @Autowired
    TripService tripService;



    @PostMapping("/trip-booking")
    public TripBooking bookTrip(@RequestBody TripBooking tripBooking) {
        System.out.println("Trip booked: " + tripBooking);

        // 1. call to trip-info service ruunning on port 9090
        // RestTemplate restTemplate = new RestTemplate();
        // String tripInfoServiceUrl = "http://localhost:9090/api/trips/search/" + tripBooking.getTitle();
        // Trip trip = restTemplate.getForObject(tripInfoServiceUrl, Trip.class);
        
        Trip trip = tripService.getTripByTitle(tripBooking.getTitle());
        log.info("Trip from trip-info service: " + trip);


        // 2. multiply booking amount by price of trip
        double totalAmount = tripBooking.getPax() * trip.getPrice();
        tripBooking.setBookingAmount(totalAmount);
        tripBooking.setPort(trip.getPort());

        // 3. return the trip booking object

        return tripBooking;
    }
    
    
}
