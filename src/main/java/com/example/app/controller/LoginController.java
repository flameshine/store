package com.example.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the login page.
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Principal principal) {
        return principal != null ? "redirect:/home" : "/login";
    }
}