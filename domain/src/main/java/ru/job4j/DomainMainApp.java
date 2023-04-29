package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DomainMainApp {
    public static void main(String[] args) {
        SpringApplication.run(DomainMainApp.class);
        System.out.println("Hello world!");
    }
}