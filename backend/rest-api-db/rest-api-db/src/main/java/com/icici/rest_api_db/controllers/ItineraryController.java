package com.icici.rest_api_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.icici.rest_api_db.entities.Itinerary;
import com.icici.rest_api_db.repos.ItineraryRepository;

@RestController
public class ItineraryController {

    @Autowired
    ItineraryRepository itineraryRepository;
    
    @GetMapping("/itineraries")
    public List<Itinerary> fetchAllItineraries(){
        return itineraryRepository.findAll();
    }

    @PostMapping("/itineraries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItinerary(@RequestBody Itinerary itinerary){
        itineraryRepository.save(itinerary);
    }
}
