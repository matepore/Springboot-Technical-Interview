package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Wallet;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.DuplicatedWalletException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.WalletNotFoundException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.repositories.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository wRepository;
    private final DollarService dollarService;

    private WalletDto mapDto(Wallet wallet){
        return WalletDto.builder()
                .id(wallet.getId())
                .salary(wallet.getSalary())
                .salaryInDollars(wallet.getSalaryInDollars())
                .build();
    }

    private Wallet mapEntity(WalletDto wDto){
        return Wallet.builder()
                .id(wDto.getId())
                .salary(wDto.getSalary())
                .salaryInDollars(wDto.getSalaryInDollars())
                .build();
    }

    @Override
    public WalletDto create(WalletDto wdto) {
        log.info("Adding a new wallet to the database.");
        if(wRepository.existsById(wdto.getId())){
            throw new DuplicatedWalletException(wdto.getId());
        }
        Wallet wallet = wRepository.save(mapEntity(wdto));
        return mapDto(wallet);
    }

    @Override
    @Cacheable("wallets")
    public WalletDto findById(Long id) {
        log.info("Trying to find the wallet with the id: {}", id);
        return wRepository.findById(id)
                .map(wallet -> this.mapDto(wallet))
                .orElseThrow(() -> new WalletNotFoundException(id));
    }

    @Override
    @CachePut(value = "wallets", key = "result.id")
    public WalletDto update(Long id, WalletDto wdto) {
        log.info("Updating the wallet with the id: {}", id);
        Wallet wallet = wRepository.findById(id).orElseThrow(() -> new WalletNotFoundException(id));
        wallet.setId(wdto.getId());
        wallet.setSalary(wdto.getSalary());
        wallet.setSalaryInDollars(getDollarSalary(wdto.getSalary()));
        return mapDto(wRepository.save(wallet));
    }

    @Override
    @CacheEvict(value = "wallets", key = "#id")
    public void delete(Long id) {
        log.info("Deleting the wallet with the id: {}", id);
        if(!wRepository.existsById(id)){
            throw new WalletNotFoundException(id);
        }
        wRepository.deleteById(id);
    }

    @Override
    public List<WalletDto> list() {
        log.info("Showing a list of all the wallets.");
        return wRepository.findAll().stream().map(wallet -> this.mapDto(wallet)).toList();
    }

    private float getDollarSalary(float salary){
        return salary * dollarService.getBlue().getCompra();
    }
}
