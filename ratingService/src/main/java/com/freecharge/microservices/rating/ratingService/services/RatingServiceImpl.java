package com.freecharge.microservices.rating.ratingService.services;

import com.freecharge.microservices.rating.ratingService.entities.Rating;
import com.freecharge.microservices.rating.ratingService.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository repository;
    @Override
    public Rating findRating(String ratingId) {
        return repository.findById(ratingId).orElseThrow();
    }

    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> findAllRating() {
        return repository.findAll();
    }

    @Override
    public List<Rating> findAllRatingByUserId(String ratingId) {
        return repository.findByUserId(ratingId);
    }

    public List<Rating> findAllRatingByHotelId(String hotelId){
        return repository.findByHotelId(hotelId);
    }
}
