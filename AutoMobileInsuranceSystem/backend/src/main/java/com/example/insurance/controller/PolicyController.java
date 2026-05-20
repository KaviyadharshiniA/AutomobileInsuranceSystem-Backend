package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.Policy;
import com.example.insurance.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins="*")
public class PolicyController {

    @Autowired
    PolicyService service;


    @PostMapping
    public Policy savePolicy(

            @RequestBody
            Policy policy){

        return service.savePolicy(
                policy);

    }


    @GetMapping
    public List<Policy> getPolicies(){

        return service.getAllPolicies();

    }


    @GetMapping("/{id}")
    public Policy getPolicyById(

            @PathVariable Long id){

        return service.getPolicyById(
                id);

    }


    @PutMapping("/{id}")
    public Policy updatePolicy(

            @PathVariable Long id,

            @RequestBody
            Policy policy){

        return service.updatePolicy(
                id,
                policy);

    }


    @DeleteMapping("/{id}")
    public String deletePolicy(

            @PathVariable Long id){

        service.deletePolicy(
                id);

        return "Policy Deleted";

    }

}