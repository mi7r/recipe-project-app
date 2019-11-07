package com.spring.radek.recipeproject.validators;

import com.spring.radek.recipeproject.commands.UserCommand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserCommand userCommand = (UserCommand) obj;
        return userCommand.getPassword().equals(userCommand.getMatchingPassword());
    }
}
