package com.sda.iManu.web.controller;

import com.sda.iManu.domain.User;
import com.sda.iManu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RENT on 2016-09-22.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @SuppressWarnings("unused")
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value= "/createUser")
    public ModelAndView createUser() {
        return new ModelAndView("createUser").addObject("user", new User());
    }

    @RequestMapping(method = RequestMethod.POST, value= "/login")
    public ModelAndView handleNewUser(@ModelAttribute User user) {
        System.out.println(user.toString());
//        User user = new User();
//        userRepository.save(user, new BCryptPasswordEncoder().encode(user.getPassword()));
        return new ModelAndView("login").addObject("user", user);
//    }
    }
}
