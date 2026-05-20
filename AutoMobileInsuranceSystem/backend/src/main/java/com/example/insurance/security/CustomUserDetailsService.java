package com.example.insurance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.insurance.entity.User;
import com.example.insurance.repository.UserRepository;

@Service
public class CustomUserDetailsService
implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(
            String email)
            throws UsernameNotFoundException {

        User user=
                repository
                .findByEmail(email)
                .orElseThrow(
                        ()->new UsernameNotFoundException(
                                "User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(
                        user.getEmail())
                .password(
                        user.getPassword())
                .roles(
                        user.getRole().name())
                .build();

    }

}