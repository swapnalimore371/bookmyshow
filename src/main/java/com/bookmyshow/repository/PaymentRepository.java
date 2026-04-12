package com.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
