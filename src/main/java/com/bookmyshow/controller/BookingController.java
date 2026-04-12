package com.bookmyshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.service.BookingService;



	@RestController
	@RequestMapping("/api/bookings")
	public class BookingController {

	    @Autowired
	    BookingService service;

	    @PostMapping
	    public Booking book(@RequestBody Booking booking){
	        return service.book(booking);
	    }

	    @GetMapping
	    public List<Booking> getAll(){
	        return service.getAll();
	    }
	}