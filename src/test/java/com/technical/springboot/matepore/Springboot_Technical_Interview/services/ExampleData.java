package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Person;
import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Wallet;

import java.util.Arrays;
import java.util.List;

public class ExampleData {
    public static final Wallet WALLET001 = new Wallet(1L, 30.0, 32.0);
    public static final Wallet WALLET002 = new Wallet(2L, 40.0, 23.0);
    public static final Wallet WALLET003 = new Wallet(3L, 50.0, 33.0);
    public static final WalletDto WALLET_DTO001 = new WalletDto(1L, 30.0, 32.0);
    public static final WalletDto WALLET_DTO002 = new WalletDto(2L, 40.0, 23.0);
    public static final WalletDto WALLET_DTO003 = new WalletDto(3L, 50.0, 33.0);
    public static final List<Wallet> WALLETS = Arrays.asList(WALLET001, new Wallet(2L, 40.0, 23.0), WALLET003);

    public static final Person PERSON001 = new Person(1L, "John", "Doe", WALLET001);
    public static final Person PERSON002 = new Person(2L, "Jane", "Doe", WALLET002);
    public static final Person PERSON003 = new Person(3L, "James", "Sunderland", WALLET003);
    public static final PersonDto PERSON_DTO001 = new PersonDto(1L, "John", "Doe", WALLET001);
    public static final PersonDto PERSON_DTO002 = new PersonDto(2L, "Jane", "Doe", WALLET002);
    public static final PersonDto PERSON_DTO003 = new PersonDto(3L, "James", "Sunderland", WALLET003);
    public static final List<Person> PERSONS = Arrays.asList(PERSON001, PERSON002, PERSON003);
}
