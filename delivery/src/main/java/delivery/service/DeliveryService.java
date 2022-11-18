package delivery.service;

import domain.model.Courier;

import java.util.Collection;

public interface DeliveryService {
    Courier save(Courier courier);
    Collection<Courier> findAll();
    Courier findById(int id);
    void deleteById(int id);

}
