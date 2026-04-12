package com.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Show;

public interface ShowRepository
extends JpaRepository<Show,Long>{
}
