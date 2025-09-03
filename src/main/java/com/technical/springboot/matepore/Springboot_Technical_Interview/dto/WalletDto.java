package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Schema(
        name = "WalletDto",
        description = "DTO that represents the information of a wallet with salaries in different currencies"
)
public class WalletDto {

    @Schema(
            description = "Unique identifier of wallet",
            example = "10",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Salary in argentinian pesos",
            example = "350000.50"
    )
    private Double salary;

    @Schema(
            description = "Salary in us dollars",
            example = "1000.75"
    )
    private Double salaryInDollars;

    public WalletDto() {
    }

    public WalletDto(Long id, Double salary, Double salaryInDollars) {
        this.id = id;
        this.salary = salary;
        this.salaryInDollars = salaryInDollars;
    }
}