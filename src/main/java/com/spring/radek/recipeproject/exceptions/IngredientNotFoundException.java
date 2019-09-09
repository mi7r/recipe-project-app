package com.spring.radek.recipeproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException{
    public IngredientNotFoundException() {
        super();
    }

    public IngredientNotFoundException(String s) {
        super(s);
    }

    public IngredientNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
