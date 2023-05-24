package com.freecharge.microservices.hotel.hotelservice.service;

import com.freecharge.microservices.hotel.hotelservice.HotelServiceApplication;
import com.freecharge.microservices.hotel.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel createHotel(Hotel hotel);
    public Hotel findHotel(String hotelId);
    public List<Hotel> findAllHotels();
}
