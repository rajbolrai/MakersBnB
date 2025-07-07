package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaticPageController {
    Integer bookings = 123;
   @GetMapping("/")
    public ModelAndView landingPage(){
       ModelAndView modelAndView = new ModelAndView("/LandingPage");
       Integer nSpace = 100;
       modelAndView.addObject("nSpaces", nSpace);
       String[] reviews = new String[] {"Awesome", "Nice", "Perfect"};
       modelAndView.addObject("reviews", reviews);
       modelAndView.addObject("bookings", this.bookings);
        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView contactUsPage(){
       ModelAndView modelAndView = new ModelAndView("/ContactUs");
       String email = "test@email.com";
       modelAndView.addObject("contact", email);
       return modelAndView;
    }
}
