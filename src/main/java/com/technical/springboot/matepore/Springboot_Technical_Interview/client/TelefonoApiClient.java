package com.technical.springboot.matepore.Springboot_Technical_Interview.client;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.TelefonoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TelefonoApiClient {

    @Value("${url.telefono}")
    private String BASE_URL;
    private final RestTemplate restTemplate;


    public TelefonoResponse getNumero() {
        String url = BASE_URL + "/api/v1/telefonos/2";
        return restTemplate.getForObject(url, TelefonoResponse.class);
    }

}