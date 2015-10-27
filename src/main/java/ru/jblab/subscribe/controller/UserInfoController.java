package ru.jblab.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.jblab.subscribe.dto.Response;
import ru.jblab.subscribe.model.UserInfo;
import ru.jblab.subscribe.service.UserService;

import java.util.List;

/**
 * Created by ainurminibaev on 27.10.15.
 */
@Controller
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserInfo> getAll() {
        return userService.getAllUserInfos();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Response add(@ModelAttribute UserInfo userInfo) {
        userService.save(userInfo);
        return new Response("ok");
    }
}
