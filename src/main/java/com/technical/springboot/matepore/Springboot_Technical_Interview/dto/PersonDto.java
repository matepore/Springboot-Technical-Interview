package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Billetera;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonDto {
    private Long id;
    private String name;
    private String lastname;
    private Billetera wallet;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, String lastname, Billetera wallet) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.wallet = wallet;
    }
}
