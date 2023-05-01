package ru.job4j.v1.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.v1.model.OrderDto;
import ru.job4j.v1.model.entity.Customer;
import ru.job4j.v1.model.entity.Order;
import ru.job4j.v1.model.mappers.OrderMapper;
import ru.job4j.v1.model.status.OrderStatus;
import ru.job4j.v1.repository.OrderRepository;
import ru.job4j.v1.service.CustomerService;
import ru.job4j.v1.service.MenuService;
import ru.job4j.v1.service.OrderService;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MenuService menuService;
    private final OrderMapper orderMapper;
    private final CustomerService customerService;
    private static final String ORDER_NOT_FOUND = "This OrderId was not found: ";
    private static final String CUSTOMER_NOT_FOUND = "This CustomerId was not found: ";
    private static final String DISH_NOT_FOUND = "This Dish Name was not found: ";

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        int customerId = orderDto.getCustomerId();
        if (!customerService.isExistById(customerId)) {
            throw new IllegalArgumentException("%s%s".formatted(CUSTOMER_NOT_FOUND, customerId));
        }
        Customer customer = customerService.findCustomerById(customerId);
        Set<String> setDishes = orderDto.getProductMap().keySet();
        for (String dishName : setDishes) {
            if (!menuService.isAvailableByName(dishName)) {
                throw new IllegalArgumentException("%s%s".formatted(DISH_NOT_FOUND, dishName));
            }
        }
        Order order = orderMapper.newOrderFromDTO(orderDto, customer);
        orderRepository.save(order);
        return orderMapper.dtoFromOrder(order);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto order) {
        if (orderRepository.existsById(order.getId())) {
            throw new IllegalArgumentException(
                    "%s%s".formatted(ORDER_NOT_FOUND, order.getId()));
        }
        Order orderExist = orderRepository.findById(order.getId()).get();
        orderExist.setDishes(order.getProductMap());
        orderRepository.save(orderExist);
        return orderMapper.dtoFromOrder(orderExist);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrdersByCustomerId(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> findOrdersByStatus(OrderStatus status) {
        return orderRepository.findByOrderStatus(status);
    }

    @Override
    public OrderStatus getStatus(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException(
                "%s%s".formatted(ORDER_NOT_FOUND, orderId))).getOrderStatus();
    }

    @Override
    public Order setStatus(int orderId, OrderStatus status) {
        if (orderRepository.existsById(orderId)) {
            throw new IllegalArgumentException(
                    "%s%s".formatted(ORDER_NOT_FOUND, orderId));
        }
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("%s%s".formatted(ORDER_NOT_FOUND, orderId)));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        orderRepository.deleteOrderById(id);
        return !orderRepository.existsById(id);
    }

    @Override
    public void deleteByCustomerId(Customer customer) {
        orderRepository.deleteOrderByCustomer(customer);
    }
}
