package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SeatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Silver, Gold, Platinum
}