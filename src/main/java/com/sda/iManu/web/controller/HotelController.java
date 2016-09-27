package com.sda.iManu.web.controller;

import com.sda.iManu.domain.Hotel;
import com.sda.iManu.service.impl.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RENT on 2016-09-22.
 */
@Controller
public class HotelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @SuppressWarnings("unused")
    @Autowired
    private HotelService hotelService;

    @RequestMapping(method = RequestMethod.GET, value= "/addHotel")
    public ModelAndView createHotel() {
        return new ModelAndView("addHotel")
                .addObject("hotel", new Hotel());
    }


    @RequestMapping(method = RequestMethod.POST, value= "/addHotel")
    public ModelAndView handleNewHotel(@ModelAttribute Hotel hotel,   BindingResult result) {
        hotelService.addHotel(hotel);
        return new ModelAndView("addHotel").addObject("isHotelSaved", true);
    }
}
