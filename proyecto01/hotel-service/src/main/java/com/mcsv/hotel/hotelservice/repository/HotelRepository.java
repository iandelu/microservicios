package com.mcsv.hotel.hotelservice.repository;

import com.mcsv.hotel.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
