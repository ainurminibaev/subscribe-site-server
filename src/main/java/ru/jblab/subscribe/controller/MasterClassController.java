package ru.jblab.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.jblab.subscribe.model.MasterClass;
import ru.jblab.subscribe.service.MasterClassService;

import java.util.List;

/**
 * Created by ainurminibaev on 25.10.15.
 */
@RestController
@RequestMapping(value = "/events")
public class MasterClassController {

    @Autowired
    MasterClassService masterClassService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MasterClass> findAll() {
        return masterClassService.findAll();
    }
}
