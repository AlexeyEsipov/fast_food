package kitchen.service;

import dish.service.SimpleDishService;
import domain.model.Dish;
import lombok.AllArgsConstructor;
import menuofdishes.service.SimpleMenuOfDishesService;

import java.util.Collection;

/**
 * Класс создает блюдо и помещает его в хранилище
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class SimpleKitchenService implements KitchenService {
    private final SimpleDishService dishService;
    private final SimpleMenuOfDishesService menuOfDishesService;

    /**
     * Метод создает блюдо. По наименованию блюда он получает его рецепт в меню,
     * создает блюдо и помещает его в хранилище.
     * @param nameDish наименование блюда
     * @return блюдо
     */
    @Override
    public Dish createDish(String nameDish) {
        Dish dish = menuOfDishesService.findByName(nameDish);
        return dishService.addDish(new Dish(0, dish.getName(), dish.getCost(), dish.getPrice()));
    }

    /**
     * Метод возвращает список блюд с одинаковым наименованием.
     * @param name наименование блюда
     * @return коллекция одинаковых блюд
     */
    @Override
    public Collection<Dish> getDishesByName(String name) {
        return dishService.findAllDishesByName(name);
    }
}
