package com.freecharge.microservices.hotel.hotelservice.entities;

import com.freecharge.microservices.hotel.hotelservice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GloabalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String ,Object>> notFoundHandler(ResourceNotFoundException resourceNotFoundException){
        Map map = new HashMap();
        map.put("message",resourceNotFoundException.getMessage());
        map.put("success",true);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
