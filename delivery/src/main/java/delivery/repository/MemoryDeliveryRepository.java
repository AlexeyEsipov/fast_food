package delivery.repository;

import domain.model.Courier;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class MemoryDeliveryRepository implements DeliveryRepository {
    private final Map<Integer, Courier> mapCouriers = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(0);

    @Override
    public Courier save(Courier courier) {
        courier.setId(ids.incrementAndGet());
        courier.setBusy(false);
        mapCouriers.put(courier.getId(), courier);
        return courier;
    }

    @Override
    public Collection<Courier> findAll() {
        return mapCouriers.values();
    }

    @Override
    public Optional<Courier> findById(int id) {
        return Optional.ofNullable(mapCouriers.get(id));
    }

    @Override
    public void deleteById(int id) {
        mapCouriers.remove(id);
    }

    @Override
    public Collection<Courier> findAllFreeCouriers() {
        return mapCouriers.values()
                .stream()
                .filter(Predicate.not(Courier::isBusy))
                .toList();
    }

    @Override
    public Optional<Courier> findAnyFreeCourier() {
        return mapCouriers.values()
                .stream()
                .filter(Predicate.not(Courier::isBusy))
                .findFirst();
    }
}
