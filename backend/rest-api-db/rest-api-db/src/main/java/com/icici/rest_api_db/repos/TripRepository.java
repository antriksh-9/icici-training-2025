package com.icici.rest_api_db.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.rest_api_db.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{

    Trip findByTitle(String title);
    Page<Trip> findByTitleContaining(String title, Pageable pageable);
    
}
