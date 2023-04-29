package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KitchenMainApp {
    public static void main(String[] args) {
        SpringApplication.run(KitchenMainApp.class);
        System.out.println("Hello kitchen!");
    }
}