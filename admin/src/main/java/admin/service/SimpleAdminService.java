package admin.service;

import delivery.service.DeliveryService;
import domain.model.Courier;
import lombok.AllArgsConstructor;
import menuofdishes.service.MenuOfDishesService;

/**
 * Класс описывает админа
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class SimpleAdminService implements AdminService {
    private final MenuOfDishesService menu;
    private final DeliveryService deliveryService;

    /**
     * Метод создает блюдо для меню
     * @param name наименование блюда
     * @param cost себестоимость
     * @param price цена для клиента
     */
    @Override
    public void createDishForMenu(String name, double cost, double price) {
        menu.save(name, cost, price);
    }

    @Override
    public void createCourier(String name) {
        deliveryService.save(new Courier(name));
    }
}
