package com.icici.rest_api_db.controllers;

import java.time.LocalDateTime;

public class ErrorMessage {
    String status;
    LocalDateTime localDateTime;
    String message;
    String description;
    public ErrorMessage(String status, String message, String description) {
        this.status = status;
        this.localDateTime = LocalDateTime.now();
        this.message = message;
        this.description = description;
    }

    

}
