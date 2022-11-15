package dish.service;

import domain.model.Dish;
import lombok.AllArgsConstructor;
import java.util.Collection;

/**
 * Класс создает блюдо и помещает его в хранилище
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class KitchenService {
    private final DishService dishService;
    private final MenuOfDishesService menuOfDishesService;

    /**
     * Метод создает блюдо. По наименованию блюда он получает его рецепт в меню,
     * создает блюдо и помещает его в хранилище.
     * @param nameDish наименование блюда
     * @return блюдо
     */
    public Dish createDish(String nameDish) {
        Dish dish = menuOfDishesService.findByName(nameDish);
        return dishService.addDish(new Dish(0, dish.getName(), dish.getCost(), dish.getPrice()));
    }

    /**
     * Метод возвращает список блюд с одинаковым наименованием.
     * @param name наименование блюда
     * @return коллекция одинаковых блюд
     */
    public Collection<Dish> getDishesByName(String name) {
        return dishService.findAllDishesByName(name);
    }
}
