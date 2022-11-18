package dish.service;

import dish.repository.DishRepository;
import domain.model.Dish;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * Класс описывает сервис по хранению готовых блюд.
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class SimpleDishService implements DishService {
    private final DishRepository store;

    /**
     * Добавляет блюдо в хранилище
     * @param dish блюдо
     * @return возвращает добавленное блюдо с установленным
     * идентификационным номером
     */
    @Override
    public Dish addDish(Dish dish) {
        return store.addDish(dish);
    }

    /**
     * Сообщает обо всех находящихся в хранилище блюдах
     * @return коллекция блюд
     */
    @Override
    public Collection<Dish> findAll() {
        return store.findAll();
    }

    /**
     * Ищет блюдо по его Id
     * @param id идентификационный номер
     * @return блюдо
     */
    @Override
    public Dish findById(int id) {
        return store.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Ищет блюдо по его Id
     * @param name идентификационный номер
     * @return блюдо
     */
    @Override
    public Dish findOneDishByName(String name) {
        return store.findByName(name).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Ищет в хранилище блюда по названию и возвращает коллекцию таких блюд
     * @param name название блюда
     * @return коллекция блюд
     */
    @Override
    public Collection<Dish> findAllDishesByName(String name) {
        return store.findAll().stream().filter(d -> d.getName().equals(name)).toList();
    }

    /**
     * Ищет в хранилище блюда по названию и возвращает количество таких блюд в хранилище
     * @param name название блюда
     * @return количество
     */
    @Override
    public int numberOfDishesNamed(String name) {
        return findAllDishesByName(name).size();
    }

    /**
     * Удаляет блюдо из хранилища по идентификационному номеру блюда
     * @param id идентификационный номер
     */
    @Override
    public void deleteById(int id) {
        store.deleteById(id);
    }

    /**
     * Производит расчет общей себестоимости блюд из переданного списка
     * @param dishList список блюд, для которых надо рассчитать себестоимость
     * @return себестоимость
     */
    @Override
    public double getTotalCost(List<Dish> dishList) {
        return getTotal(dishList, Dish::getCost);
    }

    /**
     * Производит расчет общей цены блюд из переданного списка
     * @param dishList список блюд, для которых надо рассчитать цену
     * @return цену
     */
    @Override
    public double getTotalPrice(List<Dish> dishList) {
        return getTotal(dishList, Dish::getPrice);
    }

    /**
     * Производит расчет прибыли, полученной при реализации блюд из списка
     * @param dishList список блюд, для которых надо посчитать прибыть от реализации
     * @return прибыль
     */
    @Override
    public double getTotalProfit(List<Dish> dishList) {
        return getTotal(dishList, d -> d.getPrice() - d.getCost());
    }

    /**
     * Метод для расчета складывает соответствующие характеристики блюд
     * @param dishList список блюд
     * @param function функция расчета
     * @return результат расчета
     */
    private double getTotal(List<Dish> dishList, ToDoubleFunction<Dish> function) {
        double sum = 0.0;
        for (Dish dish : dishList) {
            sum += function.applyAsDouble(dish);
        }
        return sum;
    }
}
