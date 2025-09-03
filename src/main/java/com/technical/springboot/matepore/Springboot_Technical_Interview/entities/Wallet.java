package com.technical.springboot.matepore.Springboot_Technical_Interview.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="wallets")
@Setter
@Getter
@Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double salary;

    @Column(name = "salary_in_dollars")
    private Double salaryInDollars;

    public Wallet() {
    }

    public Wallet(Long id, Double salary, Double salaryInDollars) {
        this.id = id;
        this.salary = salary;
        this.salaryInDollars = salaryInDollars;
    }
}