package delivery.service;

import delivery.repository.DeliveryRepository;
import domain.model.Courier;
import lombok.AllArgsConstructor;
import java.util.Collection;

@AllArgsConstructor
public class SimpleDeliveryService implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Override
    public Courier save(Courier courier) {
        return deliveryRepository.save(courier);
    }

    @Override
    public Collection<Courier> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Courier findById(int id) {
        return deliveryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteById(int id) {
        deliveryRepository.deleteById(id);
    }
}
