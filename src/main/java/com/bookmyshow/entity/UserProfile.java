package com.bookmyshow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class UserProfile {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String photoUrl;

private String address;

@OneToOne
private User user;

}