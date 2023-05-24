package com.freecharge.microservices.rating.ratingService.controllers;

import com.freecharge.microservices.rating.ratingService.entities.Rating;
import com.freecharge.microservices.rating.ratingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService service;
    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        String genId = UUID.randomUUID().toString();
        rating.setRatingId(genId);
        service.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }
    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String RatingId){
        return ResponseEntity.ok(service.findRating(RatingId));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(service.findAllRating());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(service.findAllRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){
        System.out.println(hotelId);
        return ResponseEntity.ok(service.findAllRatingByHotelId(hotelId));
    }

}
