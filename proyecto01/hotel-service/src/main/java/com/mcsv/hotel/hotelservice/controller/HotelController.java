package com.mcsv.hotel.hotelservice.controller;

import com.mcsv.hotel.hotelservice.entity.Hotel;
import com.mcsv.hotel.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok().body(hotelService.getAll());
    }

    @GetMapping("/{hotelId}") public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }

}
