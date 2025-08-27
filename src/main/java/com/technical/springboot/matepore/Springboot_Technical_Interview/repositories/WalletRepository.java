package com.technical.springboot.matepore.Springboot_Technical_Interview.repositories;

import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
