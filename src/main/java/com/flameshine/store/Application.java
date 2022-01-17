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

    // TODO: extend admin functionality with the ability to manipulate with product & user data via UI
    // TODO: add multiple languages support
    // TODO: consider adding user activation/deactivation functionality

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