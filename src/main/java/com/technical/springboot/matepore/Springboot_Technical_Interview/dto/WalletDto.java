package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @NotNull(message = "Salary in pesos cannot be null")
    @PositiveOrZero(message = "Salary in pesos must be greater or equal to 0")
    @DecimalMin(value = "0.0", inclusive = true, message = "Salary in pesos must be at least 0.0")
    @Digits(integer = 12, fraction = 2, message = "Salary in pesos must have up to 12 digits and 2 decimals")
    @Schema(
            description = "Salary in Argentinian pesos",
            example = "350000.50"
    )
    private Double salary;

    @NotNull(message = "Salary in dollars cannot be null")
    @PositiveOrZero(message = "Salary in dollars must be greater or equal to 0")
    @DecimalMin(value = "0.0", inclusive = true, message = "Salary in dollars must be at least 0.0")
    @Digits(integer = 12, fraction = 2, message = "Salary in dollars must have up to 12 digits and 2 decimals")
    @Schema(
            description = "Salary in US dollars",
            example = "1000.75"
    )
    private Double salaryInDollars;
}