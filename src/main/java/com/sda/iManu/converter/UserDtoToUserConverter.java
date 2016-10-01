package com.sda.iManu.converter;

import com.sda.iManu.domain.User;
import com.sda.iManu.dto.UserDto;

/**
 * Konwertuje obiekt RegistrationDto na obiekt domenowy User.
 */
public class UserDtoToUserConverter
        implements IConverter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        final User result = new User();

        result.setFirstName(userDto.getFirstName());
        result.setLastName(userDto.getLastName());
        result.setLogin(userDto.getLogin());
        result.setPassword(userDto.getPassword());
        result.setEmail(userDto.getEmail());
        result.setRole(userDto.getRole());

        return result;
    }
}
