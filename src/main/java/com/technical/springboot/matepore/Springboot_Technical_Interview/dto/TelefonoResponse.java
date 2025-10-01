package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoResponse {

    private Long id;

    @NotBlank(message = "Zip code cannot be empty")
    private String codigoArea;

    @NotBlank(message = "The number cannot be empty")
    private String numero;

    @NotBlank(message = "Type cannot be empty")
    private String tipo;

    @NotBlank(message = "Operator cannot be empty")
    private String operadora;

    @NotBlank(message = "Country cannot be empty")
    private String pais;

    @NotBlank(message = "State cannot be empty")
    private String estado;

    @NotNull(message = "Owner cannot be empty")
    private Propietario propietario;
}
