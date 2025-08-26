package com.technical.springboot.matepore.Springboot_Technical_Interview.entities;

import jakarta.persistence.*;

@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastname;
    private Billetera wallet;

    public Person() {
    }

    public Person(Integer id, String name, String lastname, Billetera wallet) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.wallet = wallet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Billetera getWallet() {
        return wallet;
    }

    public void setWallet(Billetera wallet) {
        this.wallet = wallet;
    }
}
