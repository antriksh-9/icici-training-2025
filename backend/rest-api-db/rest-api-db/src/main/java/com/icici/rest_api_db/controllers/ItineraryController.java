package com.icici.rest_api_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.icici.rest_api_db.entities.Activity;
import com.icici.rest_api_db.entities.Itinerary;
import com.icici.rest_api_db.repos.ItineraryRepository;

@RestController
@CrossOrigin
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

    @PostMapping("/itineraries/{id}/activities")
    @ResponseStatus(HttpStatus.CREATED)
    public void addActivityToItinerary(@PathVariable("id")int id,  @RequestBody Activity activity){
        Itinerary itinerary = itineraryRepository.findById(id).orElseThrow(()-> new RuntimeException("Itinerary not found"));
        itinerary.getActivities().add(activity);
        itineraryRepository.save(itinerary);

        // itineraryRepository.save(activity);
    }

    @DeleteMapping("/itineraries/{id}/activities/{activityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivityFromItinerary(@PathVariable("id") int id, @PathVariable("activityId") int activityId) {
        Itinerary itinerary = itineraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));

        itinerary.getActivities().removeIf(activity -> activity.getId() == activityId);
        itineraryRepository.save(itinerary);
    }
   

    
}
