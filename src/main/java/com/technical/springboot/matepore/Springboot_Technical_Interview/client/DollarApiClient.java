package com.technical.springboot.matepore.Springboot_Technical_Interview.client;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.DollarResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DollarApiClient {

    @Value("${url.dollarapi}")
    private String BASE_URL;
    private final RestTemplate restTemplate;

    public DollarApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DollarResponse getBlue() {
        String url = BASE_URL + "/blue";
        return restTemplate.getForObject(url, DollarResponse.class);
    }

    public DollarResponse getOficial() {
        String url = BASE_URL + "/oficial";
        return restTemplate.getForObject(url, DollarResponse.class);
    }
}

