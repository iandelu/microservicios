package com.raccoon.usuarioservicio.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "info")
    private String info;

    @Transient
    private List<Review> reviews;

}
