package com.freecharge.user.service.userService.services.impl;

import com.freecharge.user.service.userService.entities.Hotel;
import com.freecharge.user.service.userService.entities.Rating;
import com.freecharge.user.service.userService.entities.User;
import com.freecharge.user.service.userService.exceptions.ResourceNotFoundException;
import com.freecharge.user.service.userService.external.services.HotelService;
import com.freecharge.user.service.userService.external.services.RatingService;
import com.freecharge.user.service.userService.repositories.UserRepository;
import com.freecharge.user.service.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId );
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with id not found on server"+userId));
        Rating[] userRatings =restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
        List<Rating> ratings = Arrays.stream(userRatings).toList();
        List<Rating> userRatingWithHotel=ratings.stream().map(rating -> {
            //ResponseEntity<Hotel> h=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(userRatingWithHotel);
        return user;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }

    @Override
    public Rating createRating(Rating rating) {
        Rating ratingAdded = ratingService.createRating(rating);
        return ratingAdded;
    }
}
