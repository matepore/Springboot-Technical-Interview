package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers;

import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.DuplicatedPersonException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.DuplicatedWalletException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.PersonNotFoundException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.WalletNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<?> personNotFound(PersonNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage(), "timestamp", Instant.now().toString()));
    }

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<?> walletNotFound(WalletNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage(), "timestamp", Instant.now().toString()));
    }

    @ExceptionHandler(DuplicatedPersonException.class)
    public ResponseEntity<Map<String, Object>> duplicatedPerson(DuplicatedPersonException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("error", "Duplicated person conflict");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DuplicatedWalletException.class)
    public ResponseEntity<Map<String, Object>> duplicatedWallet(DuplicatedWalletException ex){
        Map<String, Object> error = new HashMap<>();
        error.put("error", "Duplicated wallet conflict");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
