package com.icici.rest_api_db.services;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icici.rest_api_db.entities.Trip;
import com.icici.rest_api_db.repos.TripRepository;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private FileStorageService fileStorageService;
    
     public void createTripWithImage(String title, String description, LocalDate startDate, LocalDate endDate, MultipartFile image) throws IOException {
        // Validate image file
        if (image != null && !fileStorageService.isValidImageFile(image)) {
            throw new RuntimeException("Invalid image file. Please upload a valid image.");
        }


        // Store image if provided
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = fileStorageService.storeFile(image);
        }

        // Create trip
        Trip trip = Trip.builder()
                .title(title)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .imageUrl(imageUrl)
                .build();

        tripRepository.save(trip);
    }
}
