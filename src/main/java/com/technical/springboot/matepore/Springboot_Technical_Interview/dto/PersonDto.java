package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Wallet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
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

    @Schema(
            description = "Name of the person",
            example = "John"
    )
    private String name;

    @Schema(
            description = "Lastname of the person",
            example = "Doe"
    )
    private String lastname;

    @Schema(
            description = "Wallet object associated with person"
    )
    private Wallet wallet;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, String lastname, Wallet wallet) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.wallet = wallet;
    }
}
