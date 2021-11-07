package com.flameshine.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * Main class that launches the application.
 */

@SpringBootApplication
public class Application {

    // TODO: clarify pagination behaviour
    // TODO: add styles to admin page
    // TODO: extend admin functionality (add an ability to manipulate with product data directly from UI)
    // TODO: add currency conversion functionality
    // TODO: add product images support
    // TODO: implement CSRF protection
    // TODO: prepare initial database popularization scripts
    // TODO: review database design
    // TODO: cover all the logic with corresponding unit-tests
    // TODO: review, refactor and optimize everything after the main functionality is implemented
    // TODO: consider migrating the codebase to Kotlin

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}