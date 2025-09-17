package com.icici.trip_app.service;
import com.icici.trip_app.entity.Trip;
import com.icici.trip_app.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public java.util.Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public Trip searchTripsByTitle(String title) {
        Trip trip = tripRepository.findByTitle(title);
        return trip;
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }
}