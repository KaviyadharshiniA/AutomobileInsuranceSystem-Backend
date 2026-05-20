package com.example.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.insurance.entity.Proposal;

public interface ProposalRepository
extends JpaRepository<Proposal,Long>{

}