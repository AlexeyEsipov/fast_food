package menuofdishes.repository;

import domain.model.Dish;
import lombok.AllArgsConstructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class MemoryMenuOfDishesRepository implements MenuOfDishesRepository {
    private final Map<Integer, Dish> dishMenu = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(1);

    @Override
    public void save(String name, double cost, double price) {
        Dish newDish = new Dish(0, name, cost, price);
        newDish.setId(ids.incrementAndGet());
        dishMenu.put(newDish.getId(), newDish);
    }

    @Override
    public Dish findById(int id) {
        return dishMenu.get(id);
    }

    @Override
    public Dish findByName(String name) {
        Dish result = new Dish();
        for (Dish dish : dishMenu.values()) {
            if (dish.getName().equals(name)) {
                result = dish;
                break;
            }
        }
        return result;
    }

    public void deleteById(int id) {
        dishMenu.remove(id);
    }
}
