package com.flameshine.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * Main class that launches the application.
 */

@SpringBootApplication
public class Application {

    // TODO: extend admin functionality (add an ability to manipulate with product & user data directly from UI)
    // TODO: add logging
    // TODO: add currency conversion functionality
    // TODO: add multiple languages support
    // TODO: consider adding product images support
    // TODO: consider adding user activation/deactivation and all corresponding mechanisms
    // TODO: consider migrating the codebase to Kotlin

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}