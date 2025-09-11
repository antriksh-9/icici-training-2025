package com.icici.rest_api_db.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String description;

    LocalDate startDate;
    LocalDate endDate;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    // @JsonIgnore
    // dont alway fetch itineraries unless required

    // lazy fetch not working
    // https://stackoverflow.com/questions/37637320/jpa-hibernate-lazy-fetching
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Itinerary> itineraries;
    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getDescription() {
    //     return description;
    // }
    // public void setDescription(String description) {
    //     this.description = description;
    // }
    // public LocalDate getStartDate() {
    //     return startDate;
    // }
    // public void setStartDate(LocalDate startDate) {
    //     this.startDate = startDate;
    // }
    // public LocalDate getEndDate() {
    //     return endDate;
    // }
    // public void setEndDate(LocalDate endDate) {
    //     this.endDate = endDate;
    // }
    // public List<Itinerary> getItineraries() {
    //     return itineraries;
    // }
    // public void setItineraries(List<Itinerary> itineraries) {
    //     this.itineraries = itineraries;
    // }

    

    
}
