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

    @NotBlank(message = "Codigo de area no puede estar vacío")
    private String codigoArea;

    @NotBlank(message = "Número no puede estar vacío")
    private String numero;

    @NotBlank(message = "Tipo no puede estar vacío")
    private String tipo;

    @NotBlank(message = "Operadora no puede estar vacía")
    private String operadora;

    @NotBlank(message = "Pais no puede estar vacío")
    private String pais;

    @NotBlank(message = "Estado no puede estar vacío")
    private String estado;

    @NotNull(message = "Propietario no puede ser nulo")
    private Propietario propietario;
}
