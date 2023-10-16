package com.raccoon.usuarioservicio.service;

import com.raccoon.usuarioservicio.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);
}
