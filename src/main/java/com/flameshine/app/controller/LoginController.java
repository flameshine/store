package com.flameshine.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.flameshine.app.util.Constants;

/**
 * Controller for the login page.
 */

@Controller
public class LoginController {

    @GetMapping(Constants.LOGIN_PATH)
    public String login(Principal principal) {
        return principal != null ? Constants.HOME_PATH : Constants.LOGIN_PATH;
    }
}