package com.freecharge.microservices.hotel.hotelservice.repositories;

import com.freecharge.microservices.hotel.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String > {
}
