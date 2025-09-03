package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.DollarResponse;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.DollarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "TestController")
@RequestMapping("/api/tests")
public class TestController {

    private final DollarService dollarService;

    @GetMapping
    public ResponseEntity<DollarResponse> getBlue(){
        return ResponseEntity.ok(dollarService.getBlue());
    }
}