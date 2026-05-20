package com.example.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.insurance.entity.Review;

public interface ReviewRepository
extends JpaRepository<Review,Long>{

}