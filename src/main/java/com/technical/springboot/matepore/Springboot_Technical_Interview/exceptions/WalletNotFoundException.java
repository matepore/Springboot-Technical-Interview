package com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions;

public class WalletNotFoundException extends RuntimeException{

    public WalletNotFoundException(Long id){
        super("The wallet with the id:" + id + " has not been found.");
    }
}