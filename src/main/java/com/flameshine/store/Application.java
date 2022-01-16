package com.flameshine.store;

import java.net.http.HttpClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main class that launches the application.
 */

@SpringBootApplication
public class Application {

    // TODO: consider converting possible interfaces into functional ones
    // TODO: extend admin functionality (add an ability to manipulate with product & user data directly from UI)
    // TODO: add multiple languages support
    // TODO: consider adding user activation/deactivation and all corresponding mechanisms
    // TODO: consider migrating the codebase to Kotlin

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}