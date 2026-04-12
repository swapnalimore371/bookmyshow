package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShowPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private double price;
}