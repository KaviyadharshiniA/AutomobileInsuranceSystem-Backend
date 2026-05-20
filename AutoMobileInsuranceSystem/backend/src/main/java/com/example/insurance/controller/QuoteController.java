package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.Quote;
import com.example.insurance.service.QuoteService;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins="*")
public class QuoteController {

    @Autowired
    QuoteService service;


    @PostMapping
    public Quote createQuote(

            @RequestBody
            Quote quote){

        return service.generateQuote(
                quote);

    }


    @GetMapping
    public List<Quote> getQuotes(){

        return service.getAllQuotes();

    }


    @GetMapping("/{id}")
    public Quote getQuote(

            @PathVariable
            Long id){

        return service.getQuoteById(
                id);

    }


    @DeleteMapping("/{id}")
    public String deleteQuote(

            @PathVariable
            Long id){

        service.deleteQuote(id);

        return "Quote deleted";

    }

}