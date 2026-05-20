package com.example.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.insurance.entity.Claim;

public interface ClaimRepository
extends JpaRepository<Claim,Long>{

}