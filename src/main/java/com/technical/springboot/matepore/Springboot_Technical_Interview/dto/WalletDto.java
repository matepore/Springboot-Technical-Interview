package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class WalletDto {
    private Long id;
    private float salary;
    private float salaryInDollars;

    public WalletDto() {
    }

    public WalletDto(Long id, float salary, float salaryInDollars) {
        this.id = id;
        this.salary = salary;
        this.salaryInDollars = salaryInDollars;
    }
}
