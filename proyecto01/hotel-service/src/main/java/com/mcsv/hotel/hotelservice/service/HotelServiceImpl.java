package com.mcsv.hotel.hotelservice.service;

import com.mcsv.hotel.hotelservice.entity.Hotel;
import com.mcsv.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.mcsv.hotel.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: "+id));
    }
}
