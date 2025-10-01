package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers.rest;

import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    public static final String ERROR = "error";
    public static final String TIME_STAMP = "timestamp";
    public static final String MESSAGE = "message";

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, Object>> personNotFound(PersonNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(ERROR, ex.getMessage(), TIME_STAMP, Instant.now().toString()));
    }

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<Map<String, Object>> walletNotFound(WalletNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(ERROR, ex.getMessage(), TIME_STAMP, Instant.now().toString()));
    }

    @ExceptionHandler(DuplicatedPersonException.class)
    public ResponseEntity<Map<String, Object>> duplicatedPerson(DuplicatedPersonException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put(ERROR, "Duplicated person conflict");
        error.put(MESSAGE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DuplicatedWalletException.class)
    public ResponseEntity<Map<String, Object>> duplicatedWallet(DuplicatedWalletException ex){
        Map<String, Object> error = new HashMap<>();
        error.put(ERROR, "Duplicated wallet conflict");
        error.put(MESSAGE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DollarNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleDollarNotFound(DollarNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put(TIME_STAMP, LocalDateTime.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put(ERROR, "Not Found");
        error.put(MESSAGE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> internalServerException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(ERROR, ex.getMessage(), TIME_STAMP, Instant.now().toString()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        //Extract errors by field
        List<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> {
                    Map<String, String> e = new HashMap<>();
                    e.put("field", error.getField());
                    e.put("rejectedValue", String.valueOf(error.getRejectedValue()));
                    e.put(MESSAGE, error.getDefaultMessage());
                    return e;
                })
                .toList();

        // Construct response
        Map<String, Object> response = new HashMap<>();
        response.put(TIME_STAMP, Instant.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("errors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}