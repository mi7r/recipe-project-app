package com.spring.radek.recipeproject.controllers;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.exceptions.EmailAlreadyExistsException;
import com.spring.radek.recipeproject.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    private static final String REGISTRATION_FORM = "registration";

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/registration")
    public String showRegistrationForm(Model model) {
        UserCommand userCommand = new UserCommand();
        model.addAttribute("user", userCommand);
        return REGISTRATION_FORM;
    }

    @PostMapping("user/registration")
    public String registerNewUser(@Valid @ModelAttribute("user") UserCommand userCommand, BindingResult bindingResult) {
        UserCommand registered = new UserCommand();

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> log.error(objectError.toString()));
            return REGISTRATION_FORM;

        }
        else if (!bindingResult.hasErrors()) {
            registered = createUserAccount(userCommand);
        }
        if (registered == null) {
            bindingResult.rejectValue("email", "error.user", "This email is already in use.");
            return REGISTRATION_FORM;
        }
        return "redirect:/login";
    }

    private UserCommand createUserAccount(UserCommand userCommand) {
        UserCommand registered = null;
        try {
            registered = userService.saveUserCommand(userCommand);
        } catch (EmailAlreadyExistsException ex) {
            log.info("This: " + userCommand.getEmail() + ", e-mail address is already in use!");
            return null;
        }
        return registered;
    }
}
