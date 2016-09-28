package com.sda.iManu.web.controller;

import com.sda.iManu.domain.Hotel;
import com.sda.iManu.domain.Tour;
import com.sda.iManu.service.impl.HotelService;
import com.sda.iManu.service.impl.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by RENT on 2016-09-22.
 */
@Controller
public class TourController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @SuppressWarnings("unused")
    @Autowired
    private TourService tourService;

    @Autowired
    private HotelService hotelService;


    @RequestMapping(method = RequestMethod.GET, value= "/addTour")
    public ModelAndView createTour() {
        List<Hotel> hotels = hotelService.getAll();
        return new ModelAndView("addTour")
                .addObject("tour", new Tour())
                .addObject("hotels", hotels);
    }


    @RequestMapping(method = RequestMethod.POST, value= "/addTour")
    public ModelAndView handleNewTour(@ModelAttribute Tour tour,   BindingResult result) {
        tourService.addTour(tour);
        return createTour();
//    }
    }
}
