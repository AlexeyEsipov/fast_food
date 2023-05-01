package ru.job4j.v1.service;


import ru.job4j.v1.model.OrderDto;
import ru.job4j.v1.model.entity.Customer;
import ru.job4j.v1.model.entity.Order;
import ru.job4j.v1.model.status.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    Order saveOrder(Order order);
    OrderDto updateOrder(OrderDto orderDto);
    List<Order> findAllOrder();
    List<Order> findOrdersByCustomerId(int customerId);
    List<Order> findOrdersByStatus(OrderStatus status);
    OrderStatus getStatus(int orderId);
    Order setStatus(int orderId, OrderStatus status);
    boolean deleteOrder(int id);
    void deleteByCustomerId(Customer customer);
}
