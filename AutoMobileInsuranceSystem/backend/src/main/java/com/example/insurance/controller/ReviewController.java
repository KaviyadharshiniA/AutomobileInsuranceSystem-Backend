package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.Review;
import com.example.insurance.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins="*")
public class ReviewController {

    @Autowired
    ReviewService service;

    @PostMapping
    public Review saveReview(
            @RequestBody Review review){

        return service.saveReview(
                review);

    }

    @GetMapping
    public List<Review> getReviews(){

        return service.getReviews();

    }

}