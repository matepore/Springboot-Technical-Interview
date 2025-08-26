package com.technical.springboot.matepore.Springboot_Technical_Interview.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="billeteras")
@Setter
@Getter
@Builder
public class Billetera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float salary;

    @Column(name = "salary_in_dollars")
    private float salaryInDollars;

    public Billetera() {
    }

    public Billetera(Integer id, float salary, float salaryInDollars) {
        this.id = id;
        this.salary = salary;
        this.salaryInDollars = salaryInDollars;
    }

}
