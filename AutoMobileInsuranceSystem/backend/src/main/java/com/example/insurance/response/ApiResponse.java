package com.example.insurance.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse {

    private boolean success;

    private String message;

}