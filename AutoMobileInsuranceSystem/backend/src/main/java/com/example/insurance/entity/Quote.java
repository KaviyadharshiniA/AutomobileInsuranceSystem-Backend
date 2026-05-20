package com.example.insurance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Quote {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Double quoteAmount;

    private String generatedDate;


    @OneToOne
    @JoinColumn(name="proposal_id")
    private Proposal proposal;

}