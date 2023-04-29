package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminMainApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminMainApp.class);
        System.out.println("Hello admin!");
    }
}