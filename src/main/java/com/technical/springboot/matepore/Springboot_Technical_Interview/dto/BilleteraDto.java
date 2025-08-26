package com.technical.springboot.matepore.Springboot_Technical_Interview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BilleteraDto {
    private Long id;
    private float salary;
    private float salaryInDollars;

    public BilleteraDto() {
    }

    public BilleteraDto(Long id, float salary, float salaryInDollars) {
        this.id = id;
        this.salary = salary;
        this.salaryInDollars = salaryInDollars;
    }
}
