package com.olsson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olsson.model.Visitor;
import com.olsson.repository.VisitorRepository;

@Controller
public class VisitorController {

    @Autowired
    VisitorRepository visitorRepository;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("visitors", visitorRepository.findAll());
        return "home";
    }

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    public String addVisitor(@ModelAttribute Visitor visitor) {
        visitorRepository.save(visitor);
        return "redirect:home";
    }
}
