package com.technical.springboot.matepore.Springboot_Technical_Interview.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="persons")
@Setter
@Getter
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private Billetera wallet;

    public Person() {
    }

    public Person(Long id, String name, String lastname, Billetera wallet) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.wallet = wallet;
    }

}
