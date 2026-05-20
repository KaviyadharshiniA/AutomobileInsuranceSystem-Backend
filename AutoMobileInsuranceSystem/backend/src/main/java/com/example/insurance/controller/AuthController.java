package com.example.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.dto.*;
import com.example.insurance.entity.User;
import com.example.insurance.repository.UserRepository;
import com.example.insurance.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
public class AuthController {

    @Autowired
    AuthService service;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    UserRepository repository;


    @PostMapping("/register")
    public String register(

            @RequestBody
            RegisterRequest request){

        return service.register(
                request);

    }


    @PostMapping("/login")
    public LoginResponse login(

            @RequestBody
            LoginRequest request){

        manager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user=
                repository
                        .findByEmail(
                                request.getEmail())
                        .get();

        return service.login(
                user);

    }

}