package com.mcsv.calificacion.service;

import com.mcsv.calificacion.entity.Review;
import com.mcsv.calificacion.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByUserId(String userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> getReviewsByHotelId(String hotelId) {
        return reviewRepository.findByHotelId(hotelId);
    }
}
