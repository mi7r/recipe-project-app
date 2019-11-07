package com.spring.radek.recipeproject.exceptions;

public final class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super();
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    public EmailAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
