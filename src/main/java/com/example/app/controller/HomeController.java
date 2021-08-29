package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the application home page.
 */

@Controller
public class HomeController {

    @GetMapping({ "/", "/home" })
    public String home() {
        return "/home";
    }
}