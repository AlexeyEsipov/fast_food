package order.repository;

import domain.model.Order;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class MemoryOrderRepository implements OrderRepository {
    private final Map<Integer, Order> mapOrder = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(1);
    @Override
    public Optional<Order> save(Order order) {
        order.setId(ids.incrementAndGet());
        mapOrder.put(order.getId(), order);
        return Optional.of(order);
    }

    @Override
    public Collection<Order> findAll() {
        return mapOrder.values();
    }

    @Override
    public Collection<Order> findAllCompleted() {
        return findByPredicate(mapOrder.values(), Order::isCompleted);
    }

    @Override
    public Collection<Order> findAllNotCompleted() {
        return findByPredicate(mapOrder.values(), Predicate.not(Order::isCompleted));
    }

    @Override
    public Optional<Order> findById(int id) {
        return Optional.ofNullable(mapOrder.get(id));
    }

    @Override
    public Collection<Order> findByUserId(int id) {
        return findByPredicate(mapOrder.values(), order -> order.getUser().getId() == id);
    }

    @Override
    public void removeById(int id) {
        mapOrder.remove(id);
    }

    private Collection<Order> findByPredicate(Collection<Order> orders, Predicate<Order> filter) {
        return orders.stream().filter(filter).toList();
    }
}
