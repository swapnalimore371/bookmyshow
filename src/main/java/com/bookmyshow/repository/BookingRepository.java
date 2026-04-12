package com.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Booking;

public interface BookingRepository
extends JpaRepository<Booking,Long>{
}