package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.Claim;
import com.example.insurance.enums.ClaimStatus;
import com.example.insurance.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class ClaimController {

    @Autowired
    ClaimService service;

    @PostMapping
    public Claim createClaim(
            @RequestBody
            Claim claim){

        return service.createClaim(
                claim);

    }

    @GetMapping
    public List<Claim> getClaims(){

        return service.getAllClaims();

    }

    @PutMapping("/{id}/{status}")
    public Claim updateClaim(

            @PathVariable Long id,

            @PathVariable ClaimStatus status){

        return service.updateClaimStatus(
                id,
                status);

    }

}