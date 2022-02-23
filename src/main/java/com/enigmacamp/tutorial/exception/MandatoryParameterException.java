package com.enigmacamp.tutorial.exception;

public class MandatoryParameterException extends Exception {
    public MandatoryParameterException(String message) {
        super("Mandatory parameter is required : " + message);
    }
}
