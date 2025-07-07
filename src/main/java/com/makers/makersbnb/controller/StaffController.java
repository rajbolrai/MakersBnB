package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaffController {
    @GetMapping("/team")
    public ModelAndView teamPage(){
        ModelAndView modelAndView = new ModelAndView("/Team");
        String teamMembers = "Toby, Katerine, Sandy";
        modelAndView.addObject("team_members",  teamMembers);
        return modelAndView;
    }
}
