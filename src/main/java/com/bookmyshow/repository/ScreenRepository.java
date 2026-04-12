package com.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookmyshow.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {}