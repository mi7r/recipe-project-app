package com.spring.radek.recipeproject.services;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.converters.UserCommandToUser;
import com.spring.radek.recipeproject.converters.UserToUserCommand;
import com.spring.radek.recipeproject.domain.User;
import com.spring.radek.recipeproject.exceptions.NotFoundException;
import com.spring.radek.recipeproject.exceptions.UserAlreadyExistsException;
import com.spring.radek.recipeproject.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;
    private final UserRepository userRepository;

    public UserServiceImpl(UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser, UserRepository userRepository) {
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserCommand saveUserCommand(UserCommand userCommand) {
        Optional<User> userOptional = userRepository.findByEmail(userCommand.getEmail());

        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User with given e-mail address already exists.");
        }

        User newUser = userCommandToUser.convert(userCommand);
        userRepository.save(newUser);
        log.info("User with e-mail address: " + newUser.getEmail() + " created.");

        return userToUserCommand.convert(newUser);

    }

    @Override
    public UserCommand findById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            throw new NotFoundException("User with ID: " + userId.toString() + " not found.");
        }
        return userToUserCommand.convert(userOptional.get());
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);

    }
}
