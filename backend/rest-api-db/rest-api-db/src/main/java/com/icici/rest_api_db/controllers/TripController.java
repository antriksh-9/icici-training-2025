package com.icici.rest_api_db.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.icici.rest_api_db.entities.Trip;
import com.icici.rest_api_db.repos.TripRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TripController {

    @Autowired
    TripRepository tripRepository;

    @GetMapping("/trips")
    public List<Trip> fetchAllTrips() {
        // logic to fetch from DB
        return tripRepository.findAll();
    }

     @GetMapping("/trips/{id}")
    public Trip fetchATrip(@PathVariable("id") int id){
         Optional<Trip> tripFound = tripRepository.findById(id);
         if(tripFound.isPresent()){
            return tripFound.get();
         }
         else{
            throw new TripNotFoundException("Trip not found with id " + id);
         }
    }

    @PostMapping("/trips")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrips(@RequestBody Trip trip) {
        tripRepository.save(trip);
    }

    @DeleteMapping("/trips/{id}")
    public void deleteTrip(@PathVariable("id") int id){
       try{
            tripRepository.deleteById(id);
       }
       catch(Exception e){
        e.printStackTrace();
       }
        
    }
    
    
    
}
