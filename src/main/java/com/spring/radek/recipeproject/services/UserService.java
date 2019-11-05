package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.exceptions.EmailExistsException;

public interface UserService {

    UserCommand saveUserCommand(UserCommand userCommand) throws EmailExistsException;

    UserCommand findById(Long userId);

    void deleteById(Long userId);
}
