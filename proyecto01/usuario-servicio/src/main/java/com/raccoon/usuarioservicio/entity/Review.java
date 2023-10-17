package com.raccoon.usuarioservicio.entity;

import lombok.Data;

@Data
public class Review {

    private String reviewId;
    private String userId;
    private String hotelId;
    private int rating;
    private String comments;
    private Hotel hotel;

}
