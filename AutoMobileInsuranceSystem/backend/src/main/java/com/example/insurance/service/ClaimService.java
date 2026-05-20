package com.example.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.Claim;
import com.example.insurance.enums.ClaimStatus;
import com.example.insurance.repository.ClaimRepository;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository repository;

    public Claim createClaim(
            Claim claim){

        claim.setClaimStatus(
                ClaimStatus.INITIATED);

        return repository.save(
                claim);

    }

    public List<Claim> getAllClaims(){

        return repository.findAll();

    }

    public Claim updateClaimStatus(
            Long id,
            ClaimStatus status){

        Claim claim=
                repository.findById(id)

                        .orElseThrow(
                                ()->new RuntimeException(
                                        "Claim not found"));

        claim.setClaimStatus(
                status);

        return repository.save(
                claim);

    }

}