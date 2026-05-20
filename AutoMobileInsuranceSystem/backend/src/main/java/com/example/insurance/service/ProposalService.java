package com.example.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.Proposal;
import com.example.insurance.enums.PolicyStatus;
import com.example.insurance.repository.ProposalRepository;

@Service
public class ProposalService {

    @Autowired
    ProposalRepository repository;

    public Proposal createProposal(
            Proposal proposal){

        proposal.setStatus(
                PolicyStatus.PROPOSAL_SUBMITTED);

        return repository.save(
                proposal);

    }

    public List<Proposal> getAllProposals(){

        return repository.findAll();

    }

    public Proposal updateProposalStatus(

            Long id,
            PolicyStatus status){

        Proposal proposal=
                repository.findById(id)

                        .orElseThrow(
                                ()->new RuntimeException(
                                        "Proposal not found"));

        proposal.setStatus(
                status);

        return repository.save(
                proposal);

    }

    public void deleteProposal(
            Long id){

        repository.deleteById(
                id);

    }

}