package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.job4j.model.OrderDto;

import java.util.Map;

@SpringBootApplication
public class OrderMainApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApp.class);
        System.out.println("Hello Order!");
        OrderDto orderDto = OrderDto.builder()
                .id(0)
                .customerId(0)
                .productMap(Map.of("first", 1, "second", 1))
                .build();
        System.out.println("orderDto = " + orderDto);
    }
}