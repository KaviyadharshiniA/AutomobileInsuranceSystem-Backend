package com.example.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.insurance.dto.*;
import com.example.insurance.entity.User;
import com.example.insurance.repository.UserRepository;
import com.example.insurance.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtil;

    public String register(
            RegisterRequest request){

        User user=
                new User();

        user.setName(
                request.getName());

        user.setEmail(
                request.getEmail());

        user.setPassword(
                encoder.encode(
                        request.getPassword()));

        user.setDob(
                request.getDob());

        user.setAge(
                request.getAge());

        user.setAadhaar(
                request.getAadhaar());

        user.setPan(
                request.getPan());

        user.setAddress(
                request.getAddress());

        user.setRole(
                request.getRole());

        repository.save(user);

        return "Registration Successful";

    }

    public LoginResponse login(
        User user){

    String token =
            jwtUtil.generateToken(
                    user.getEmail()
            );

    return new LoginResponse(

            user.getId(),

            token,

            user.getRole().name(),

            user.getName()

    );
}

}