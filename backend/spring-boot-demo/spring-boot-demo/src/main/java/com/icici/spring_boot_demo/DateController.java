package com.icici.spring_boot_demo;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class DateController {
    
    @GetMapping("/date")
    public LocalDateTime getServerDateTime(){
        return LocalDateTime.now();
    }
    

    
}
