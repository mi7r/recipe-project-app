package com.spring.radek.recipeproject.commands;

import com.spring.radek.recipeproject.validators.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String password;


    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
}
