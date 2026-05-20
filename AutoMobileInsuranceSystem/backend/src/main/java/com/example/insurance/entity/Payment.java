package com.example.insurance.entity;

import com.example.insurance.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String paymentMethod;

    private String paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


    @OneToOne
    @JoinColumn(name="quote_id")
    private Quote quote;

}