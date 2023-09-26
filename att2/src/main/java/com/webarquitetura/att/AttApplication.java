package com.webarquitetura.att;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AttApplication {


    @Bean
    public CommandLineRunner init() {
        return args -> {

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AttApplication.class, args);
    }
}