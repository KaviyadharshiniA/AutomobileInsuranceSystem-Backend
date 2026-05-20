package com.example.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.Policy;
import com.example.insurance.repository.PolicyRepository;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository repository;

    public Policy savePolicy(
            Policy policy){

        return repository.save(
                policy);

    }

    public List<Policy> getAllPolicies(){

        return repository.findAll();

    }

    public Policy getPolicyById(
            Long id){

        return repository.findById(id)

                .orElseThrow(
                        ()->new RuntimeException(
                                "Policy not found"));

    }

    public Policy updatePolicy(
            Long id,
            Policy policy){

        Policy oldPolicy=
                repository.findById(id)
                        .orElseThrow(
                                ()->new RuntimeException(
                                        "Policy not found"));

        oldPolicy.setPolicyName(
                policy.getPolicyName());

        oldPolicy.setDescription(
                policy.getDescription());

        oldPolicy.setPackageType(
                policy.getPackageType());

        oldPolicy.setPremiumAmount(
                policy.getPremiumAmount());

        oldPolicy.setAddOns(
                policy.getAddOns());

        return repository.save(
                oldPolicy);

    }

    public void deletePolicy(
            Long id){

        repository.deleteById(id);

    }

}