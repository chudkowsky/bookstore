package com.example.bookstore_project.controller;

import com.example.bookstore_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    BookService bookService;
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("books", this.bookService.getAll());
        return "home";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "hello, user!";
    }
}