package com.raccoon.usuarioservicio.service;

import com.raccoon.usuarioservicio.entity.User;
import com.raccoon.usuarioservicio.exception.ResourceNotFoundException;
import com.raccoon.usuarioservicio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

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
       return repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
