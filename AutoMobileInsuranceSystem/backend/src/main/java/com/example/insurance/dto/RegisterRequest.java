package com.example.insurance.dto;

import com.example.insurance.enums.Role;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {

    private String name;

    private String email;

    private String password;

    private String dob;

    private Integer age;

    private String aadhaar;

    private String pan;

    private String address;

    private Role role;

}