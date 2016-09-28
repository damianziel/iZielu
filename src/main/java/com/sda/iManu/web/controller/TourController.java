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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
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
    public ModelAndView handleNewTour(@ModelAttribute Tour tour, BindingResult result) {
        tourService.addTour(tour);
        return createTour();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

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
