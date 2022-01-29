package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.ModelAndView;
import lombok.RequiredArgsConstructor;

import com.flameshine.store.service.UserOperator;
import com.flameshine.store.util.Constants;

/**
 * Users page controller.
 */

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserOperator operator;

    @GetMapping(Constants.USERS_PATH)
    public ModelAndView findAllPageable(
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("criterion") Optional<String> criterion
    ) {

        var users = operator.findAllPageable(
            PageRequest.of(
                page.map(i -> i - 1).orElse(0),
                10,
                Sort.by(
                    criterion.orElse("username")
                )
            )
        );

        return new ModelAndView(Constants.USERS_PATH)
            .addObject("users", users);
    }
}