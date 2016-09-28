package com.sda.iManu.converter;

import com.sda.iManu.domain.User;
import com.sda.iManu.dto.UserDto;

/**
 * Konwertuje obiekt RegistrationDto na obiekt domenowy User.
 */
public class UserDtoToUserConverter
        implements IConverter<UserDto, User>{

    @Override
    public User convert(UserDto userDto) {
        final User result = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail()
        );
        return result;
    }
}
