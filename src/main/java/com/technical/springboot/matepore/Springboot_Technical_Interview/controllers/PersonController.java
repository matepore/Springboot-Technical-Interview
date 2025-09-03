package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService pService;

    public PersonController(PersonService pService) {
        this.pService = pService;
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto pdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pService.create(pdto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(pService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody PersonDto pdto){
        return ResponseEntity.ok(pService.update(id, pdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        pService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //I don't define a different path because the base mapping works as a get all persons.
    @GetMapping
    public ResponseEntity<List<PersonDto>> list(){
        return ResponseEntity.ok(pService.list());
    }
}