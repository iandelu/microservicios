package com.mcsv.hotel.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String localization;
    private String info;
}
