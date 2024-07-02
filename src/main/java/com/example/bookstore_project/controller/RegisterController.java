package com.example.bookstore_project.controller;

import com.example.bookstore_project.model.User;
import com.example.bookstore_project.service.BookService;
import com.example.bookstore_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes) {

        String result = userService.registerUser(user);
        model.addAttribute("message", result);
        redirectAttributes.addAttribute("message", result);
        if (result.equals("success")) {
            return "redirect:/login";
        }
        return "register";
    }



}