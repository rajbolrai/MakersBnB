package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@RestController
public class SpaceController {
    @Autowired
    SpaceRepository spaceRepository;

    @GetMapping("/spaces")
    public ModelAndView spacePage() {
        ModelAndView modelAndView = new ModelAndView("/SpacePage");
        Iterable<Space> spaces = spaceRepository.findAll();
        modelAndView.addObject("spaces", spaces);
        return modelAndView;
    }

    @GetMapping("/spaces/new")
    public ModelAndView newSpaceForm(){
        Space space = new Space();
        ModelAndView newSpaceForm = new ModelAndView("spaces/addNewSpace");
        newSpaceForm.addObject("space", space);
        return newSpaceForm;
    }

    @GetMapping("/spaces/findSpacesByDate")
    public ModelAndView getSpaceByDate(){
        ModelAndView modelAndView = new ModelAndView("spaces/findSpacesByDate");
        return modelAndView;
    }

    @PostMapping("/spaces")
    public RedirectView create(Space space){
        spaceRepository.save(space);
        return new RedirectView("/spaces");
    }
}
