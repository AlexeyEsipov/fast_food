package kitchen.service;

import domain.model.Dish;

/**
 * Класс создает блюдо и помещает его в хранилище
 * @author Есипов Алексей
 * @version 1.0
 */
public class SimpleKitchenService implements KitchenService {

    /**
     * Метод создает блюдо. По наименованию блюда он получает его рецепт в меню,
     * создает блюдо и помещает его в хранилище.
     * @param name наименование блюда
     * @return блюдо
     */
    @Override
    public Dish createDish(String name, double cost, double price) {
        return new Dish(0, name, cost, price);
    }
}
