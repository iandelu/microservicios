package com.mcsv.calificacion.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("calificaciones")
public class Review {
    @Id
    private String reviewId;
    private String userId;
    private String hotelId;
    private int rating;
    private String comment;
}
