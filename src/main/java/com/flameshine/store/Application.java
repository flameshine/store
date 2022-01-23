package com.flameshine.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * Main class that launches the application.
 */

@SpringBootApplication
public class Application {

    // TODO: cover key login with corresponding unit tests
    // TODO: extend admin functionality with the ability to manipulate with product & user data via UI
    // TODO: add multiple languages support
    // TODO: consider adding user activation/deactivation functionality

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}