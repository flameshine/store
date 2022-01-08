package com.flameshine.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.flameshine.store.util.Constants;

/**
 * Controller for the application home page.
 */

@Controller
public class HomeController {

    @GetMapping({ "/", Constants.HOME_PATH })
    public String home() {
        return Constants.HOME_PATH;
    }
}