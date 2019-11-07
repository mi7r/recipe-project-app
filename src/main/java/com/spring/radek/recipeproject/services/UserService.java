package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.exceptions.EmailAlreadyExistsException;

public interface UserService {

    UserCommand saveUserCommand(UserCommand userCommand) throws EmailAlreadyExistsException;

    UserCommand findById(Long userId);

    void deleteById(Long userId);
}
