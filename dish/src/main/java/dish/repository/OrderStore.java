package dish.repository;

import domain.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderStore {
    Optional<Order> add(Order order);
    Collection<Order> findAll();
    Collection<Order> findAllCompleted();
    Collection<Order> findAllNotCompleted();
    Optional<Order> findById(int id);
    Collection<Order> findByUserId(int id);
    void removeById(int id);
}
