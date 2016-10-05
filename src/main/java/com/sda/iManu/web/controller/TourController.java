package com.sda.iManu.web.controller;

import com.sda.iManu.converter.TourDtoToTourConverter;
import com.sda.iManu.domain.Hotel;
import com.sda.iManu.dto.TourDto;
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

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2016-09-22.
 */
@Controller
public class TourController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private TourDtoToTourConverter converter = new TourDtoToTourConverter();

    @SuppressWarnings("unused")
    @Autowired
    private TourService tourService;

    @Autowired
    private HotelService hotelService;


    @RequestMapping(method = RequestMethod.GET, value = "/addTour")
    public ModelAndView createTour() {
        LOGGER.info("Start");
        List<Hotel> hotels = hotelService.getAll();
        return new ModelAndView("addTour")
                .addObject("tourDto", new TourDto())
                .addObject("hotels", hotels);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addTour")
    public ModelAndView handleNewTour(@Valid @ModelAttribute TourDto tourDto, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.info("error: {}", result.getAllErrors());
            return new ModelAndView("error");
        } else {
            if (tourService.addTour(converter.convert(tourDto))) {
                LOGGER.info("tour created: {}", tourDto);
                List<Hotel> hotels = hotelService.getAll();
                return new ModelAndView("addTour").addObject("hotels", hotels);
            } else {
                LOGGER.info("cannot add tour");
                return new ModelAndView("error");
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tourList")
    public ModelAndView showAllTours(@ModelAttribute TourDto tourDto) {

        List<TourDto> listOfTours = tourService
                .showAllTours()
                .stream()
                .map(TourDto::fromTour)
                .collect(Collectors.toCollection(LinkedList::new));
        return new ModelAndView("tourList").addObject("listOfTours", listOfTours);
    }
}
