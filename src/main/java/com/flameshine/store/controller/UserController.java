package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.ModelAndView;

import com.flameshine.store.service.UserService;
import com.flameshine.store.util.Constants;
import com.flameshine.store.util.Pager;

/**
 * Controller for the application users page.
 */

@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(Constants.USERS_PATH)
    public ModelAndView findAllPageable(
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("criterion") Optional<String> criterion
    ) {

        var users = service.findAllPageable(
            PageRequest.of(
                page.map(i -> i - 1).orElse(0),
                10,
                Sort.by(
                    criterion.orElse("username")
                )
            )
        );

        return new ModelAndView(Constants.USERS_PATH)
            .addObject("users", users)
            .addObject("pager", new Pager(users));
    }
}