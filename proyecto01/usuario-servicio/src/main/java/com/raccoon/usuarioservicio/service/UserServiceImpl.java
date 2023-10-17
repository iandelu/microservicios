package com.raccoon.usuarioservicio.service;

import com.raccoon.usuarioservicio.entity.Hotel;
import com.raccoon.usuarioservicio.entity.Review;
import com.raccoon.usuarioservicio.entity.User;
import com.raccoon.usuarioservicio.exception.ResourceNotFoundException;
import com.raccoon.usuarioservicio.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    UserRepository repository;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with ID"));
        Review[] reviewsFromUser = restTemplate.getForObject("http://localhost:8083/reviews/fromUser/"+user.getUserId(), Review[].class);

        List<Review> reviewsList = Arrays.asList(reviewsFromUser);
        List<Review> reviewsWithHotel = reviewsList.stream().map(c -> {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/"+c.getHotelId(), Hotel.class);
            logger.info("{}",forEntity.getStatusCode());
            c.setHotel(forEntity.getBody());
            return c;

        }).collect(Collectors.toList());
        logger.info("{}",reviewsWithHotel);
        user.setReviews(reviewsWithHotel);

        return user;
    }
}
