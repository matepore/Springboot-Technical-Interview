package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DollarResponse {

    private String casa;
    private String nombre;
    private Integer compra;
    private Integer venta;
    private String moneda;

    @JsonProperty("fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}
