package ru.job4j.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryMainApp {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryMainApp.class);
        System.out.println("Hello delivery!");
    }
}