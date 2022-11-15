package dish.service;

import domain.model.Dish;
import lombok.AllArgsConstructor;

/**
 * Класс описывает админа
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class AdminService {
    private final MenuOfDishesService menu;
    private final DishService dishService;

    /**
     * Метод создает блюдо для меню
     * @param name наименование блюда
     * @param cost себестоимость
     * @param price цена для клиента
     */
    public void createDishForMenu(String name, double cost, double price) {
        menu.addNewDishToMenu(name, cost, price);
    }

    /**
     * Метод создает блюдо для создания запаса
     * @param dish блюдо
     */
    public void createDishForStore(Dish dish) {
        dishService.addDish(dish);
    }

}
