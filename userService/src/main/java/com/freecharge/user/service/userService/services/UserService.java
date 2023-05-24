package com.freecharge.user.service.userService.services;

import com.freecharge.user.service.userService.entities.Rating;
import com.freecharge.user.service.userService.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User deleteUser(String userId);

    Rating createRating(Rating rating);
}
