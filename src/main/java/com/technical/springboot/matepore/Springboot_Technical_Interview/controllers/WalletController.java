package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService wService;

    public WalletController(WalletService wService) {
        this.wService = wService;
    }

    @PostMapping
    public ResponseEntity<WalletDto> create(@RequestBody WalletDto wdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(wService.create(wdto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(wService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletDto> update(@PathVariable Long id, @RequestBody WalletDto wdto){
        return ResponseEntity.ok(wService.update(id, wdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        wService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //I don't define a different path because the base mapping works as a get all wallets.
    @GetMapping
    public ResponseEntity<List<WalletDto>> list(){
        return ResponseEntity.ok(wService.list());
    }
}
