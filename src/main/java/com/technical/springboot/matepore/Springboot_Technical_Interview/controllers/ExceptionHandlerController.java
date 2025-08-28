package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers;

import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.PersonNotFoundException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.WalletNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<?> personNotFound (PersonNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage(), "timestamp", Instant.now().toString()));
    }

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<?> walletNotFound (WalletNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage(), "timestamp", Instant.now().toString()));
    }
}
