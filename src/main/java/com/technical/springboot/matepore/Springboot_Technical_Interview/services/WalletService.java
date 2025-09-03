package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;

import java.util.List;

public interface WalletService {
    WalletDto create(WalletDto wdto);
    WalletDto findById(Long id);
    WalletDto update(Long id, WalletDto wdto);
    void delete (Long id);
    List<WalletDto> list();
}