package com.enigmacamp.tutorial.exception;

public class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super("Data not found : " + message);
    }
}
