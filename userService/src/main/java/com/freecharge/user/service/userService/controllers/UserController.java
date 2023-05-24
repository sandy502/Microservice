package com.freecharge.user.service.userService.controllers;

import com.freecharge.user.service.userService.entities.Rating;
import com.freecharge.user.service.userService.entities.User;
import com.freecharge.user.service.userService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user1 = userService.getUser(userId);
        return ResponseEntity.ok(user1);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
        System.out.println("called because service is down :"+ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("User created as service is down").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{userId}/{hotelId}")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        Rating ratingres = userService.createRating(rating);
        return ResponseEntity.ok(ratingres);
    }
}
