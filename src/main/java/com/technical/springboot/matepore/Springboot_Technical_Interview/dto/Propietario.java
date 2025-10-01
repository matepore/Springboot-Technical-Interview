package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Propietario {
    @NotBlank(message = "Name cannot be empty")
    private String nombre;

    @NotBlank(message = "Lastname cannot be empty")
    private String apellido;
}