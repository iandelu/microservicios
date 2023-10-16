package com.raccoon.usuarioservicio.repository;

import com.raccoon.usuarioservicio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
