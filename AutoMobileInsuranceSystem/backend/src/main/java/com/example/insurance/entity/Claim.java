package com.example.insurance.entity;

import com.example.insurance.enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Claim {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String claimReason;

    private String claimDescription;

    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}