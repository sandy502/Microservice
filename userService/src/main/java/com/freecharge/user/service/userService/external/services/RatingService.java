package com.freecharge.user.service.userService.external.services;

import com.freecharge.user.service.userService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    public Rating createRating(Rating rating);
}
