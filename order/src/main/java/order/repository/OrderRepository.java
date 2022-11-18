package order.repository;

import domain.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> save(Order order);
    Collection<Order> findAll();
    Collection<Order> findAllCompleted();
    Collection<Order> findAllNotCompleted();
    Optional<Order> findById(int id);
    Collection<Order> findByUserId(int id);
    void removeById(int id);
}
