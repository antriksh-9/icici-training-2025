package com.icici.trip_booking_app.dto;

import lombok.Data;

@Data
public class Trip {
     private Long id;
    private String title;
    private String description;
    private Double price;
    
    int port;

}
