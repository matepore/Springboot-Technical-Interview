package com.technical.springboot.matepore.Springboot_Technical_Interview.entities;

import org.springframework.stereotype.Component;

@Component
public class Billetera {
    private float salary;
    private float dollarsConversion;

    public Billetera() {
    }

    public Billetera(float salary, float dollarsConversion) {
        this.salary = salary;
        this.dollarsConversion = dollarsConversion;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getDollarsConversion() {
        return dollarsConversion;
    }

    public void setDollarsConversion(float dollarsConversion) {
        this.dollarsConversion = dollarsConversion;
    }
}
