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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @OneToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;

    public Person() {
    }

    public Person(Long id, String name, String lastname, Wallet wallet) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.wallet = wallet;
    }

}
