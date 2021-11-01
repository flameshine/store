package com.example.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.util.Constants;

/**
 * Controller for the login page.
 */

@Controller
public class LoginController {

    @GetMapping(Constants.LOGIN_PATH)
    public String login(Principal principal) {
        return principal != null ? "redirect:/home" : Constants.LOGIN_PATH;
    }
}