package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Wallet;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Schema(
        name = "PersonDto",
        description = "DTO that represents a person with their associated wallet"
)
public class PersonDto {

    @Schema(
            description = "Unique identifier of person",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = "Name cannot be blank")
//    @Pattern(regexp = "^(?!Yoel$).*$", message = "Name cannot be 'Yoel'")
    @Size(max = 5, message = "Name cannot exceed 5 characters")
    @Schema(
            description = "Name of the person",
            example = "John"
    )
    private String name;

    @NotBlank(message = "Lastname cannot be blank")
    @Size(max = 50, message = "Lastname cannot exceed 50 characters")
    @Schema(
            description = "Lastname of the person",
            example = "Doe"
    )
    private String lastname;

    @Valid
    @NotNull(message = "Wallet cannot be null")
    @Schema(
            description = "Wallet object associated with person"
    )
    private Wallet wallet;
}