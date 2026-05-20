package com.example.insurance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Policy {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    private String description;

    private String packageType;

    private Double premiumAmount;

    private String addOns;

}