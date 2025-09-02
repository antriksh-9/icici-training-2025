package com.icici.rest_api_db.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TripNotFoundException extends RuntimeException{
    public TripNotFoundException(String message){
        super(message);
    }
}
