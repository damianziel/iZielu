package com.sda.iManu.web.controller;

import com.sda.iManu.domain.Tour;
import com.sda.iManu.repository.TourRepository;
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
public class TourController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @SuppressWarnings("unused")
    @Autowired
    private TourRepository tourRepository;

    @RequestMapping(method = RequestMethod.GET, value= "/addTour")
    public ModelAndView createTour() {
        return new ModelAndView("addTour").addObject("tour", new Tour());
    }

    @RequestMapping(method = RequestMethod.POST, value= "/addTour")
    public ModelAndView handleNewTour(@ModelAttribute Tour tour) {
        tourRepository.save(tour);
        return new ModelAndView("addTour").addObject("isTourSaved", true);
//    }
    }
}
