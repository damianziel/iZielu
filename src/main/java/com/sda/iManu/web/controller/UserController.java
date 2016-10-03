package com.sda.iManu.web.controller;

import com.sda.iManu.converter.UserDtoToUserConverter;
import com.sda.iManu.dto.UserDto;
import com.sda.iManu.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserDtoToUserConverter converter = new UserDtoToUserConverter();

    @SuppressWarnings("unused")
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value= "/createUser")
    public ModelAndView createUser() {
        LOGGER.info("Start");
        return new ModelAndView("createUser").addObject("userDto", new UserDto());
    }

    @RequestMapping(method = RequestMethod.POST, value= "/createUser")
    public ModelAndView handleNewUser(@Valid @ModelAttribute UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.info("error: {}", result.getAllErrors());
            return new ModelAndView("createUser");
        } else {
             if (userService.addUser(converter.convert(userDto))) {
                LOGGER.info("user created: {}", userDto);
                return new ModelAndView("login");
            } else {
                LOGGER.info("cannot add user");
                return new ModelAndView("createUser");
            }
        }
    }
//      the same but in a different way
//    just for me

//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView startRegisterProcess(ModelMap model) {
//        LOGGER.info("start");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("data", new UserDto());
//        modelAndView.setViewName("register");
//        return modelAndView;


//    @RequestMapping(method = RequestMethod.POST)
//    public String register(
//            @ModelAttribute(value = "data") @Valid UserDto userDto,
//            BindingResult result,
//            ModelMap model) {
//        LOGGER.info("start");
//
//        if (result.hasErrors()) {
//            LOGGER.info("error: {}", result.getAllErrors());
//            return "register";
//        } else {
//            if (userService.registerUser(converter.convert(userDto))) {
//                LOGGER.info("user created: {}", userDto);
//                return "login";
//            } else {
//                LOGGER.info("cannot add user");
//                return "register";
//            }
//        }
//    }
}
