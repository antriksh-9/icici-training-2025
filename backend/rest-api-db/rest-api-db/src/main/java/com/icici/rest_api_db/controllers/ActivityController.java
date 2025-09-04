package com.icici.rest_api_db.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.icici.rest_api_db.entities.Activity;
import com.icici.rest_api_db.repos.ActivityRepository;

@RestController
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;
    
    @DeleteMapping("/activities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivity(@PathVariable("id") int id){
        activityRepository.deleteById(id);
    }
  
}
