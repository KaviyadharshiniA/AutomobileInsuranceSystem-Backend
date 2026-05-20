package com.example.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.Review;
import com.example.insurance.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository;

    public Review saveReview(
            Review review){

        return repository.save(
                review);

    }

    public List<Review> getReviews(){

        return repository.findAll();

    }

}