package com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id){
        super("The person with the id:" + id + " has not been found.");
    }
}