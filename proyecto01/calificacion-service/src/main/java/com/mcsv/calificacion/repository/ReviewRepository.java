package com.mcsv.calificacion.repository;

import com.mcsv.calificacion.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, Long> {

    List<Review> findByUserId(String userId);
    List<Review> findByHotelId(String hotelId);

}
