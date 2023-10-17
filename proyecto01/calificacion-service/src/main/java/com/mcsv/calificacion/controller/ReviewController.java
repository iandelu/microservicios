package com.mcsv.calificacion.controller;

import com.mcsv.calificacion.entity.Review;
import com.mcsv.calificacion.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(review));
    }

    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getReviews());
    }

    @GetMapping("/fromUser/{userId}")
    public ResponseEntity<List<Review>> getReviewFromUser(@PathVariable String userId){
        return ResponseEntity.ok(reviewService.getReviewsByUserId(userId));
    }

    @GetMapping("/fromHotel/{hotelId}")
    public ResponseEntity<List<Review>> getReviewFromHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(reviewService.getReviewsByHotelId(hotelId));
    }





}
