package com.raccoon.usuarioservicio.service;

import com.raccoon.usuarioservicio.entity.Review;
import com.raccoon.usuarioservicio.entity.User;
import com.raccoon.usuarioservicio.exception.ResourceNotFoundException;
import com.raccoon.usuarioservicio.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        ArrayList<Review> reviewsFromUser = restTemplate.getForObject("http://localhost:8083/reviews/fromUser/"+user.getUserId(), ArrayList.class);
        logger.info("{}",reviewsFromUser);
        user.setReviews(reviewsFromUser);

        return user;
    }
}
