package ru.jblab.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.jblab.subscribe.form.FilterForm;
import ru.jblab.subscribe.service.MasterClassService;

/**
 * Created by ainurminibaev on 06.11.15.
 */
@Controller
public class PagesController {

    @Autowired
    MasterClassService masterClassService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/law2", method = RequestMethod.GET)
    public String congratsPage() {
        return "law2";
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public String activities(Model model) {
        model.addAttribute("activities", masterClassService.filter(null));
        return "activities";
    }

    @RequestMapping(value = "/activities/filter", method = RequestMethod.POST)
    public String activities(@ModelAttribute FilterForm filterForm, Model model) {
        model.addAttribute("activities", masterClassService.filter(filterForm));
        return "/parts/activities-macro";
    }

    @RequestMapping(value = "/activities/{id:[0-9]+}/{alias}", method = RequestMethod.GET)
    public String activities(@PathVariable(value = "id") Long id, @PathVariable(value = "alias") String alias, Model model) {
        model.addAttribute("event", masterClassService.findOne(id));
        return "fullEvent";
    }
}
