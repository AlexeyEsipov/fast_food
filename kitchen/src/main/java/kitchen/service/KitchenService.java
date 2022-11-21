package kitchen.service;

import domain.model.Dish;

public interface KitchenService {
    /**
     * Метод создает блюдо. По наименованию блюда он получает его рецепт в меню,
     * создает блюдо и помещает его в хранилище.
     * @param name наименование блюда
     * @return блюдо
     */
    Dish createDish(String name, double cost, double price);
}
