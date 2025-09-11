package com.icici.rest_api_db.dto;

import java.time.LocalDate;
import java.util.List;

import com.icici.rest_api_db.entities.Itinerary;

import lombok.Data;

@Data
public class TripDTO {

    int id;
    String title;
    String description;

    LocalDate startDate;
    LocalDate endDate;

    String imageUrl;

    // List<Itinerary> itineraries;
    
}
