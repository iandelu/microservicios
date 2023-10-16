package com.mcsv.calificacion.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not found Exception");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
