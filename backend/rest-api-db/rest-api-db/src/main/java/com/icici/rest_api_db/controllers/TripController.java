package com.icici.rest_api_db.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.icici.rest_api_db.dto.TripDTO;
import com.icici.rest_api_db.entities.Itinerary;
import com.icici.rest_api_db.entities.Trip;
import com.icici.rest_api_db.repos.TripRepository;
import com.icici.rest_api_db.services.AuditLogService;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@CrossOrigin
public class TripController {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    private AuditLogService auditLogService;

    // Logger logger = LoggerFactory.getLogger(TripController.class);

    @Cacheable("trips")
    @GetMapping("/trips")
    public List<TripDTO> fetchAllTrips() {

            log.info("Fetching all trips from the database");
        return tripRepository.findAll().stream().map(trip -> {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setId(trip.getId());
            tripDTO.setTitle(trip.getTitle());
            tripDTO.setDescription(trip.getDescription());
            tripDTO.setStartDate(trip.getStartDate());
            tripDTO.setEndDate(trip.getEndDate());
            // tripDTO.setItineraries(null);
            return tripDTO;
        }).toList();
        // return tripRepository.findAll();
    }

     @GetMapping("/trips/search")
    public Page<Trip> fetchTripByName(@RequestParam("title") String title, @RequestParam(value = "page", defaultValue = "0", required = false) Integer page, @RequestParam(value = "size",defaultValue = "2", required = false) Integer size, @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy){
        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return tripRepository.findByTitleContaining(title, pageable); 
       
    }

     @GetMapping("/trips/{id}")
    public Trip fetchATrip(@PathVariable("id") int id){

        // In your service/controller, inject AuditLogService and call:
        auditLogService.log(
            "FIND",
            "Trip",
            ""+ id,
            "adminUser",
            Map.of("fieldChanged", "email", "oldValue", "a@b.com", "newValue", "b@b.com")
        );
         Optional<Trip> tripFound = tripRepository.findById(id);
         if(tripFound.isPresent()){
            log.debug("Trip found " + tripFound.get());
            return tripFound.get();
         }
         else{
            log.warn("Trip not found with id " + id);
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

    @PostMapping("/trips/{id}/itinerary")
    public void addItineraryToTrip(@PathVariable("id")int id, @RequestBody Itinerary itinerary){
        Optional<Trip> tripFound = tripRepository.findById(id);
         if(tripFound.isPresent()){
            Trip trip = tripFound.get();
            List<Itinerary> itineraries = trip.getItineraries();
            itineraries.add(itinerary);
            trip.setItineraries(itineraries);
            tripRepository.save(trip);
         }
         else{
            throw new TripNotFoundException("Trip not found with id " + id);
         }
    }
    
    
    
}
