package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.client.DollarApiClient;
import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.DollarResponse;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.DollarNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
        } catch (HttpClientErrorException.NotFound e) {
            log.error("Error in the getBlue method: " + e.getMessage());
            throw new DollarNotFoundException();
        }
        return dollarResponse;
    }

    public DollarResponse getOficial() {
        try {
            return dollarApiClient.getOficial();
        } catch (HttpClientErrorException.NotFound e) {
            log.error("Error in the getOficial method: " + e.getMessage());
            throw new DollarNotFoundException();
        }
    }
}