package com.example.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.User;
import com.example.insurance.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers(){

        return repository.findAll();

    }

    public User getUserById(Long id){

        return repository.findById(id)
                .orElseThrow(
                        ()->new RuntimeException(
                                "User not found"));

    }

    public User updateUser(
            Long id,
            User user){

        User oldUser=
                repository.findById(id)
                        .orElseThrow(
                                ()->new RuntimeException(
                                        "User not found"));

        oldUser.setName(
                user.getName());

        oldUser.setEmail(
                user.getEmail());

        oldUser.setDob(
                user.getDob());

        oldUser.setAddress(
                user.getAddress());

        oldUser.setPan(
                user.getPan());

        oldUser.setAadhaar(
                user.getAadhaar());

        return repository.save(
                oldUser);

    }

    public void deleteUser(
            Long id){

        repository.deleteById(id);

    }

}