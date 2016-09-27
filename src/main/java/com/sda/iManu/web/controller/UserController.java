package com.sda.iManu.web.controller;

import com.sda.iManu.domain.User;
import com.sda.iManu.dto.UserDto;
import com.sda.iManu.repository.UserRepository;
import com.sda.iManu.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by RENT on 2016-09-22.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @SuppressWarnings("unused")
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value= "/createUser")

    public ModelAndView createUser(@Valid User User) {
        return new ModelAndView("createUser").addObject("user", new User());
    }

    @RequestMapping(method = RequestMethod.POST, value= "/createUser")
    public ModelAndView handleNewUser(@ModelAttribute User user) {
        userService.addUser(user);
        return new ModelAndView("login").addObject("isUserSaved", true);
    }
//    @SuppressWarnings("unused")
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView createUser(ModelMap model) {
//        LOGGER.info("start");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userDto", new UserDto());
//        modelAndView.setViewName("createUser");
//        return modelAndView;
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String handleUser(@ModelAttribute(value = "userDto")
//              @Valid UserDto userDto, BindingResult result, ModelMap model) {
//        LOGGER.info("start");
//
//        if(result.hasErrors()) {
//            return "createUser";
//        }
//        else {
//            return "login";
//        }
//    }
}
