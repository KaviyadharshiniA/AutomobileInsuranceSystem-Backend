package com.example.insurance.response;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApiErrorResponse {

    private String message;

    private LocalDateTime timestamp;

}