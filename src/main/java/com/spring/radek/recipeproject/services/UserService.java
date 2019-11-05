package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.domain.User;

public interface UserService {

    UserCommand saveUserCommand(UserCommand userCommand);

    UserCommand findById(Long userId);

    void deleteById(Long userId);
}
