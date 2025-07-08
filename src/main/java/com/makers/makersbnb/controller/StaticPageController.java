package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaticPageController {

    @Autowired
    SpaceRepository spaceRepository;

   @GetMapping("/")
    public ModelAndView landingPage(){
       ModelAndView modelAndView = new ModelAndView("/LandingPage");
       Integer nSpace = 100;
       Long currentSpace = spaceRepository.count();
       modelAndView.addObject("nSpaces", currentSpace);
        String[] reviews = new String[] {"Awesome", "Nice", "Perfect"};
        modelAndView.addObject("reviews", reviews);
        modelAndView.addObject("bookings", 2);
        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView contactUsPage(){
       ModelAndView modelAndView = new ModelAndView("/ContactUs");
       String email = "test@email.com";
       modelAndView.addObject("contact", email);
       return modelAndView;
    }

    @GetMapping("/spaces")
    public ModelAndView spacePage() {
        ModelAndView modelAndView = new ModelAndView("/SpacePage");
        Iterable<Space> spaces = spaceRepository.findAll();
        modelAndView.addObject("spaces", spaces);
        return modelAndView;
    }
}
