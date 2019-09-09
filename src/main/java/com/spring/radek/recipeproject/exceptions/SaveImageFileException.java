package com.spring.radek.recipeproject.exceptions;

public class SaveImageFileException extends Exception {
    public SaveImageFileException() {
    }

    public SaveImageFileException(String s) {
        super(s);
    }

    public SaveImageFileException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
