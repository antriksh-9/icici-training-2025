package com.icici.trip_app.repository;

import com.icici.trip_app.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    Trip findByTitle(String title);
}