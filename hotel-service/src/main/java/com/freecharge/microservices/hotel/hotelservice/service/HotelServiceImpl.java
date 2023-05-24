package com.freecharge.microservices.hotel.hotelservice.service;

import com.freecharge.microservices.hotel.hotelservice.entities.Hotel;
import com.freecharge.microservices.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.freecharge.microservices.hotel.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel findHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel with given id not found"));
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }
}
