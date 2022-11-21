package admin.service;

import domain.model.Courier;
import domain.model.Dish;
import java.util.ArrayList;

/**
 * Класс описывает админа
 * @author Есипов Алексей
 * @version 1.0
 */
public class SimpleAdminService implements AdminService {

    /**
     * Метод создает блюдо для меню с целью потом отправить в сервис MenuOfDishesService для формирования меню
     * @param name наименование блюда
     * @param cost себестоимость
     * @param price цена для клиента
     */
    @Override
    public Dish createDishForMenu(String name, double cost, double price) {
        return new Dish(0, name, cost, price);
    }

    /**+
     * Метод создает курьера для сервиса доставки DeliveryService
     * @param name имя курьера
     * @return курьер
     */
    @Override
    public Courier createCourier(String name) {
        return new Courier(0, name, false, "", new ArrayList<>());
    }
}
