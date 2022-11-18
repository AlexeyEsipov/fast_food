package dish.service;

import domain.model.Dish;

import java.util.Collection;
import java.util.List;

public interface DishService {
    Dish addDish(Dish dish);

    /**
     * Сообщает обо всех находящихся в хранилище блюдах
     * @return коллекция блюд
     */
    Collection<Dish> findAll();

    /**
     * Ищет блюдо по его Id
     * @param id идентификационный номер
     * @return блюдо
     */
    Dish findById(int id);

    /**
     * Ищет блюдо по его Id
     * @param name идентификационный номер
     * @return блюдо
     */
    Dish findOneDishByName(String name);

    /**
     * Ищет в хранилище блюда по названию и возвращает коллекцию таких блюд
     * @param name название блюда
     * @return коллекция блюд
     */
    Collection<Dish> findAllDishesByName(String name);

    /**
     * Ищет в хранилище блюда по названию и возвращает количество таких блюд в хранилище
     * @param name название блюда
     * @return количество
     */
    int numberOfDishesNamed(String name);

    /**
     * Удаляет блюдо из хранилища по идентификационному номеру блюда
     * @param id идентификационный номер
     */
    void deleteById(int id);

    /**
     * Производит расчет общей себестоимости блюд из переданного списка
     * @param dishList список блюд, для которых надо рассчитать себестоимость
     * @return себестоимость
     */
    double getTotalCost(List<Dish> dishList);

    /**
     * Производит расчет общей цены блюд из переданного списка
     * @param dishList список блюд, для которых надо рассчитать цену
     * @return цену
     */
    double getTotalPrice(List<Dish> dishList);

    /**
     * Производит расчет прибыли, полученной при реализации блюд из списка
     * @param dishList список блюд, для которых надо посчитать прибыть от реализации
     * @return прибыль
     */
    double getTotalProfit(List<Dish> dishList);
}
