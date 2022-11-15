package dish.repository;

import lombok.AllArgsConstructor;
import domain.model.Dish;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс описывает хранилище для блюд. Храниться могут блюда любого наименования в любом количестве.
 * Это значит, что в хранилище может быть несколько блюд одного наименования, например, 5 блюд ПИЦЦА,
 * 10 блюд СУШИ, 20 блюд КОФЕ
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class DishMemoryRepository implements DishStore {

    private final Map<Integer, Dish> mapDish = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(1);

    /**
     * Добавляет блюдо в хранилище
     */
    @Override
    public Dish addDish(Dish dish) {
        dish.setId(ids.incrementAndGet());
        mapDish.put(dish.getId(), dish);
        return dish;
    }

    /**
     * Сообщает обо всех блюдах, находящихся в хранилище
     * @return возвращает коллекцию
     */
    @Override
    public Collection<Dish> findAll() {
        return mapDish.values();
    }

    /**
     * Находит блюдо по Id
     * @param id идентификатор блюда
     */
    @Override
    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(mapDish.get(id));
    }

    /**
     * Находит блюдо по его названию
     * @param name название
     */
    @Override
    public Optional<Dish> findByName(String name) {
        return mapDish.values().stream()
                .filter(dish -> dish.getName().equals(name))
                .findFirst();
    }

    /**
     * Удаляет блюдо по идентификатору
     * @param id идентификатор
     */
    @Override
    public void deleteById(int id) {
        mapDish.remove(id);
    }
}
