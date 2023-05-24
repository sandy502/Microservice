package com.freecharge.microservices.rating.ratingService.repositories;

import com.freecharge.microservices.rating.ratingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    public List<Rating> findByUserId(String UserId);
    public List<Rating> findByHotelId(String UserId);

}
