package com.flameshine.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView findAll(
        @RequestParam(value = "criterion", required = false, defaultValue = "username") String criterion
    ) {
        return new ModelAndView(Constants.USERS_PATH)
            .addObject(
                "users",
                operator.findAll(
                    Sort.by(criterion)
                )
            );
    }
}