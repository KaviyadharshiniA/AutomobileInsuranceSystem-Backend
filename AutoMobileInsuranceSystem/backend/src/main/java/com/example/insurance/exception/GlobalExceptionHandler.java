package com.example.insurance.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.response.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(

            RuntimeException ex){

        ApiErrorResponse response=

                new ApiErrorResponse(

                        ex.getMessage(),

                        LocalDateTime.now()

                );

        return new ResponseEntity<>(

                response,

                HttpStatus.BAD_REQUEST

        );

    }

}