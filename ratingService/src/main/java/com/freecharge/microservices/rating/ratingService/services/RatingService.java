package com.freecharge.microservices.rating.ratingService.services;

import com.freecharge.microservices.rating.ratingService.entities.Rating;

import java.util.List;

public interface RatingService {
    public Rating findRating(String ratingId);
    public Rating createRating(Rating rating);
    public List<Rating> findAllRating();
    public List<Rating> findAllRatingByUserId(String ratingId);
    public List<Rating> findAllRatingByHotelId(String hotelId);
}
