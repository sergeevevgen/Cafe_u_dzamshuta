package com.cafe.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainScreenController {
    @GetMapping
    public String showSignupForm() {
        return "null";
    }
}
