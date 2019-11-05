package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {

    @Synchronized
    @Nullable
    @Override
    public UserCommand convert(User source) {
        if (source != null) {
            final UserCommand userCommand = new UserCommand();
            userCommand.setUserName(source.getUserName());
            userCommand.setEmail(source.getEmail());
            userCommand.setPassword(source.getPassword());
            return userCommand;
        }
        return null;
    }
}
