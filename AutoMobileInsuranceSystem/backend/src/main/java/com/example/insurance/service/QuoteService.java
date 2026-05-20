package com.example.insurance.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.Quote;
import com.example.insurance.repository.QuoteRepository;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository repository;

    public Quote generateQuote(
            Quote quote){

        quote.setGeneratedDate(
                LocalDate.now()
                        .toString());

        return repository.save(
                quote);

    }

    public List<Quote> getAllQuotes(){

        return repository.findAll();

    }

    public Quote getQuoteById(
            Long id){

        return repository.findById(id)

                .orElseThrow(
                        ()->new RuntimeException(
                                "Quote not found"));

    }

    public void deleteQuote(
            Long id){

        repository.deleteById(id);

    }

}