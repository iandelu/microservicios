package com.mcsv.calificacion.service;

import com.mcsv.calificacion.entity.Review;

import java.util.List;

public interface ReviewService {
    Review create(Review review);
    List<Review> getReviews();
    List<Review> getReviewsByUserId(String userId);
    List<Review> getReviewsByHotelId(String hotelId);
}
