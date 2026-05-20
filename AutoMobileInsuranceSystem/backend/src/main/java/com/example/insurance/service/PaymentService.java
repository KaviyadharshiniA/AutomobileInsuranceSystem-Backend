package com.example.insurance.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.Payment;
import com.example.insurance.enums.PaymentStatus;
import com.example.insurance.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    public Payment savePayment(
            Payment payment){

        payment.setPaymentDate(
                LocalDate.now()
                        .toString());

        payment.setPaymentStatus(
                PaymentStatus.SUCCESS);

        return repository.save(
                payment);

    }

    public List<Payment> getAllPayments(){

        return repository.findAll();

    }

    public Payment getPayment(
            Long id){

        return repository.findById(id)

                .orElseThrow(
                        ()->new RuntimeException(
                                "Payment not found"));

    }

}