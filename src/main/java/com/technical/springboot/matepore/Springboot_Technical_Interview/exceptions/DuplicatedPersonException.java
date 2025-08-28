package com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions;

public class DuplicatedPersonException extends RuntimeException{

    public DuplicatedPersonException(Long id){
        super("There is already a person associated with the id: " + id + " in the database.");
    }
}
