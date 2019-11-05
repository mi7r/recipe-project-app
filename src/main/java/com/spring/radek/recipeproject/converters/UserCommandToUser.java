package com.spring.radek.recipeproject.converters;

import com.spring.radek.recipeproject.commands.UserCommand;
import com.spring.radek.recipeproject.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    @Synchronized
    @Nullable
    @Override
    public User convert(UserCommand source) {
        if (source != null) {
            final User user = new User();
            user.setUserName(source.getUserName());
            user.setEmail(source.getEmail());
            user.setPassword(source.getPassword());
            return user;
        }
        return null;
    }
}
