package menuofdishes.service;

import domain.model.Dish;
import lombok.AllArgsConstructor;
import menuofdishes.repository.MenuOfDishesRepository;
import java.util.Collection;

@AllArgsConstructor
public class SimpleMenuOfDishesService implements MenuOfDishesService {
    private final MenuOfDishesRepository store;

    @Override
    public void save(String name, double cost, double price) {
        store.save(name, cost, price);
    }

    @Override
    public Dish findById(int id) {
        return store.findById(id);
    }

    @Override
    public Dish findByName(String name) {
        return store.findByName(name);
    }

    public void deleteById(int id) {
        store.deleteById(id);
    }

    @Override
    public Collection<Dish> findAll() {
        return store.findAll();
    }
}
