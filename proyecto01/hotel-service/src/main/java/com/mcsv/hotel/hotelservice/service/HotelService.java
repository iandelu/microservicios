package com.mcsv.hotel.hotelservice.service;

import com.mcsv.hotel.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel getHotel(String id);
}
