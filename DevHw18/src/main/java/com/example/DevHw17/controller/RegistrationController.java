package com.example.DevHw17.controller;

import com.example.DevHw17.entities.User;
import com.example.DevHw17.noteDao.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;
    @GetMapping
    public String getRegistrationPage(){
        return "notes/registration/registration";
    }
    @PostMapping
    public String setNewUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
