package com.example.insurance.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponse {

    private Long id;

    private String token;

    private String role;

    private String username;

}