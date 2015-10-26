package ru.jblab.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.jblab.subscribe.service.MasterClassService;

/**
 * Created by ainurminibaev on 25.10.15.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    MasterClassService masterClassService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUploadPage() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String postToUpdate(@RequestParam("file") MultipartFile multipartFile) {
        masterClassService.updateMkData(multipartFile);
        return "redirect:/admin/upload";
    }
}
