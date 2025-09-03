package com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions;

public class DollarNotFoundException extends RuntimeException {
    public DollarNotFoundException() {
        super("Dollar api endpoint not found. Could be the url is wrong or the endpoint is no longer available.");
    }
}