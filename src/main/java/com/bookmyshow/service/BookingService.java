package com.bookmyshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository repo;

    public Booking book(Booking booking){
        return repo.save(booking);
    }

    public List<Booking> getAll(){
        return repo.findAll();
    }
}