package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.Payment;
import com.example.insurance.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class PaymentController {

    @Autowired
    PaymentService service;


    @PostMapping
    public Payment savePayment(

            @RequestBody
            Payment payment){

        return service.savePayment(
                payment);

    }


    @GetMapping
    public List<Payment> getPayments(){

        return service.getAllPayments();

    }


    @GetMapping("/{id}")
    public Payment getPayment(

            @PathVariable
            Long id){

        return service.getPayment(id);

    }

}