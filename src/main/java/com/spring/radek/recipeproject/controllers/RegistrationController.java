package com.spring.radek.recipeproject.controllers;

import com.spring.radek.recipeproject.commands.UserCommand;
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
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> log.error(objectError.toString()));
            return REGISTRATION_FORM;
        }

        userService.saveUserCommand(userCommand);
        return "redirect:/login";
    }
}
