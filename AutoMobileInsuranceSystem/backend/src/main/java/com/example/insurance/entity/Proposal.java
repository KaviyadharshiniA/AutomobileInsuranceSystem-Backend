package com.example.insurance.entity;

import com.example.insurance.enums.PolicyStatus;
import com.example.insurance.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Proposal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String vehicleNumber;

    private String modelName;

    private Integer vehicleAge;

    private String selectedAddons;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name="policy_id")
    private Policy policy;

}