package com.sda.iManu.web.controller;

import com.sda.iManu.converter.TourDtoToTourConverter;
import com.sda.iManu.domain.Hotel;
import com.sda.iManu.domain.Tour;
import com.sda.iManu.dto.TourDto;
import com.sda.iManu.service.impl.HotelService;
import com.sda.iManu.service.impl.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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


//    @InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }

//    @RequestMapping(value = "/owners/new", method = RequestMethod.GET)
//    public String initCreationForm(Model model) {
//        Owner owner = new Owner();
//        model.addAttribute(owner);
//        return "owners/createOrUpdateOwnerForm";
//    }
//
//    @RequestMapping(value = "/owners/new", method = RequestMethod.POST)
//    public String processCreationForm(@Valid Owner owner, BindingResult result, SessionStatus status) {
//        if (result.hasErrors()) {
//            return "owners/createOrUpdateOwnerForm";
//        } else {
//            this.clinicService.saveOwner(owner);
//            status.setComplete();
//            return "redirect:/owners/" + owner.getId();
//        }
//    }
//
//    @RequestMapping(value = "/tour/find", method = RequestMethod.GET)
//    public ModelAndView initFindForm() {
//        return new ModelAndView("tour/findTours").addObject("tour", new Tour());
//    }
//
//    @RequestMapping(value = "/tours", method = RequestMethod.GET)
//    public ModelAndView processFindForm(Tour tour, BindingResult result) {
//
//        // allow parameterless GET request for /owners to return all records
//        if (tour.getDuration() == 0) {
//            tour.setType(""); // empty string signifies broadest possible search
//        }
//
//        // find owners by last name
//        Collection<Owner> results = this.clinicService.findOwnerByLastName(owner.getLastName());
//        if (results.size() < 1) {
//            // no owners found
//            result.rejectValue("lastName", "notFound", "not found");
//            return "owners/findOwners";
//        }
//        if (results.size() > 1) {
//            // multiple owners found
//            model.addAttribute("selections", results);
//            return "owners/ownersList";
//        } else {
//            // 1 owner found
//            owner = results.iterator().next();
//            return "redirect:/owners/" + owner.getId();
//        }
//    }
//
//    @RequestMapping(value = "/owners/{ownerId}/edit", method = RequestMethod.GET)
//    public String initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, Model model) {
//        Owner owner = this.clinicService.findOwnerById(ownerId);
//        model.addAttribute(owner);
//        return "owners/createOrUpdateOwnerForm";
//    }
//
//    @RequestMapping(value = "/owners/{ownerId}/edit", method = RequestMethod.PUT)
//    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, SessionStatus status) {
//        if (result.hasErrors()) {
//            return "owners/createOrUpdateOwnerForm";
//        } else {
//            this.clinicService.saveOwner(owner);
//            status.setComplete();
//            return "redirect:/owners/{ownerId}";
//        }
//    }
//
//    /**
//     * Custom handler for displaying an owner.
//     *
//     * @param ownerId the ID of the owner to display
//     * @return a ModelMap with the model attributes for the view
//     */
//    @RequestMapping("/owners/{ownerId}")
//    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
//        ModelAndView mav = new ModelAndView("owners/ownerDetails");
//        mav.addObject(this.clinicService.findOwnerById(ownerId));
//        return mav;
//    }
//
//}

}
