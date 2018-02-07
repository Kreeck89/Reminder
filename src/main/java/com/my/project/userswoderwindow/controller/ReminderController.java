package com.my.project.userswoderwindow.controller;

import com.my.project.userswoderwindow.model.Reminder;
import com.my.project.userswoderwindow.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/main")
public class ReminderController {

    @Autowired
    private ReminderService service;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("reminders", service.getAll());
        return "main";
    }

    @RequestMapping(value = "/editor")
    public String editorPage(Model model) {
        model.addAttribute("reminder", new Reminder());
        return "editor";
    }

    @RequestMapping(value = "editor/submit", method = RequestMethod.POST)
    public String submitUser(@ModelAttribute Reminder reminder) {
        service.save(reminder);
        return "main";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
