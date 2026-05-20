package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.Proposal;
import com.example.insurance.enums.PolicyStatus;
import com.example.insurance.service.ProposalService;

@RestController
@RequestMapping("/api/proposals")
@CrossOrigin(origins="*")
public class ProposalController {

    @Autowired
    ProposalService service;


    @PostMapping
    public Proposal createProposal(

            @RequestBody
            Proposal proposal){

        return service.createProposal(
                proposal);

    }


    @GetMapping
    public List<Proposal> getAllProposals(){

        return service.getAllProposals();

    }


    @PutMapping("/{id}/{status}")

    public Proposal updateStatus(

            @PathVariable Long id,

            @PathVariable PolicyStatus status){

        return service.updateProposalStatus(
                id,
                status);

    }


    @DeleteMapping("/{id}")
    public String deleteProposal(

            @PathVariable Long id){

        service.deleteProposal(
                id);

        return "Proposal Deleted";

    }

}