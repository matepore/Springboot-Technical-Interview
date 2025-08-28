package com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions;

public class DuplicatedWalletException extends RuntimeException{

    public DuplicatedWalletException(Long id){
        super("There is already a person associated with the id: " + id + " in the database.");
    }
}
