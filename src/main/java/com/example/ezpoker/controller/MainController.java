package com.example.ezpoker.controller;

import com.example.ezpoker.entity.User;
import com.example.ezpoker.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @PostMapping(value = "/addScore")
    public String newUser(@ModelAttribute User user) {
        mainService.saveOrUpdate(user);
        return "redirect:/showScores/hide";
    }

    @GetMapping(value = "/addScore")
    public String addScorePage(Model model) {
        return "addScore";
    }

    @GetMapping(value = "/showScores/hide")
    public String showScoresButHide(Model model) {
        List<User> userList = mainService.getAllUsers();
        System.out.println("User List: " + userList);
        model.addAttribute("users", userList);
        model.addAttribute("show", false);
        return "showScores";
    }

    @GetMapping(value = "/showScores/show")
    public String showScores(Model model) {
        List<User> userList = mainService.getAllUsers();
        System.out.println("User List: " + userList);
        model.addAttribute("users", userList);
        model.addAttribute("show", true);
        return "showScores";
    }

    @GetMapping(value = "/error")
    public String error(Model model) {
        return "error";
    }

}
