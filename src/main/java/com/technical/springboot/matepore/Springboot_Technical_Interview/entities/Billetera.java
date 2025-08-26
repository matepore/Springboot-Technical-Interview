package com.technical.springboot.matepore.Springboot_Technical_Interview.entities;

import jakarta.persistence.*;

@Entity
@Table(name="billeteras")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalaryInDollars() {
        return salaryInDollars;
    }

    public void setSalaryInDollars(float salaryInDollars) {
        this.salaryInDollars = salaryInDollars;
    }
}
