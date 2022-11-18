package kitchen.service;

import domain.model.Dish;

import java.util.Collection;

public interface KitchenService {
    /**
     * Метод создает блюдо. По наименованию блюда он получает его рецепт в меню,
     * создает блюдо и помещает его в хранилище.
     * @param nameDish наименование блюда
     * @return блюдо
     */
    Dish createDish(String nameDish);

    /**
     * Метод возвращает список блюд с одинаковым наименованием.
     * @param name наименование блюда
     * @return коллекция одинаковых блюд
     */
    Collection<Dish> getDishesByName(String name);
}
