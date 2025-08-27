package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;

import java.util.List;

public interface WalletService {
    WalletDto create(WalletDto bdto);
    WalletDto findById(Long id);
    WalletDto update(Long id, WalletDto bdto);
    void delete (Long id);
    List<WalletDto> list();
}
