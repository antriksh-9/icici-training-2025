package com.icici.rest_api_db.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.icici.rest_api_db.entities.Activity;
import com.icici.rest_api_db.repos.ActivityRepository;

@RestController
@CrossOrigin
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;
    
   @PatchMapping("/activities/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActivity(@PathVariable("id") int id, @RequestBody Activity updatedActivity) {
         Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    
        
         if (updatedActivity.getDescription() != null) {
              activity.setDescription(updatedActivity.getDescription());
         }
       
    
         activityRepository.save(activity);
    }
  
}
