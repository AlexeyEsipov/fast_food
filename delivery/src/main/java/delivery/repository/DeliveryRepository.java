package delivery.repository;

import domain.model.Courier;

import java.util.Collection;
import java.util.Optional;

public interface DeliveryRepository {
    Courier save(Courier courier);
    Collection<Courier> findAll();
    Optional<Courier> findById(int id);
    void deleteById(int id);
    Collection<Courier> findAllFreeCouriers();
    Optional<Courier> findAnyFreeCourier();
}
