package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the login page.
 */

@Controller
public class LoginController {

    // TODO: add logging

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}