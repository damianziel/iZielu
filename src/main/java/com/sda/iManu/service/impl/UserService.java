package com.sda.iManu.service.impl;

import com.sda.iManu.domain.User;
import com.sda.iManu.repository.UserRepository;
import com.sda.iManu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by RENT on 2016-09-27.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public boolean addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser != null;
    }
}
