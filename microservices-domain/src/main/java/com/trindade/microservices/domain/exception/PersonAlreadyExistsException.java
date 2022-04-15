package com.trindade.microservices.domain.exception;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
