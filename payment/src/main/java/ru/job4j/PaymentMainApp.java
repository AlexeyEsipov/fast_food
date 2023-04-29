package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentMainApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainApp.class);
        System.out.println("Hello payment!");
    }
}