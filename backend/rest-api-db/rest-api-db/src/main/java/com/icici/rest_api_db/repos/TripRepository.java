package com.icici.rest_api_db.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.rest_api_db.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{
    
}
