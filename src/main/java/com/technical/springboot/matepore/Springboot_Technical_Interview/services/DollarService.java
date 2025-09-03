package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.client.DollarApiClient;
import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.DollarResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DollarService {
    private final DollarApiClient dollarApiClient;


    public DollarResponse getBlue() {
        DollarResponse dollarResponse = null;
        try {
            dollarResponse = dollarApiClient.getBlue();
            log.info("The dollar blue costs: " + dollarResponse.getCompra());
        } catch (Exception e) {
            log.error("Error in get blue " + e.getMessage());
        }
        return dollarResponse;
    }

    public DollarResponse getOficial() {
        return dollarApiClient.getOficial();
    }
}
