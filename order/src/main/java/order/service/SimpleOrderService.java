package order.service;

import domain.model.Order;
import lombok.AllArgsConstructor;
import order.repository.OrderRepository;

import java.util.Collection;
import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * Класс описывает сервис по работе с заказами.
 * @author Есипов Алексей
 * @version 1.0
 */
@AllArgsConstructor
public class SimpleOrderService implements OrderService {
    private final OrderRepository store;

    /**
     * Метод добавляет новый заказ в базу заказов
     * @param order заказ
     * @return заказ
     */
    public Order save(Order order) {
        return store.save(order).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Метод возвращает все заказы в виде коллекции
     * @return коллекция
     */
    public Collection<Order> findAll() {
        return store.findAll();
    }

    /**
     * Метод возвращает коллекцию всех выполненных заказов
     * @return коллекция
     */
    public Collection<Order> findAllCompleted() {
        return store.findAllCompleted();
    }

    /**
     * Метод возвращает коллекцию всех текущих невыполненных заказов
     * @return коллекция
     */
    public Collection<Order> findAllNotCompleted() {
        return store.findAllNotCompleted();
    }

    /**
     * Метод ищет конкретный заказ по его идентификационному номеру
     * @param id идентификационный номер
     * @return заказ
     */
    public Order findById(int id) {
        return store.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Метод ищет все заказы по идентификационному номеру заказчика
     * @param id идентификационный номер заказчика
     * @return заказ
     */
    public Collection<Order> findByUserId(int id) {
        return store.findByUserId(id);
    }

    /**
     * Метод удаляет заказ из базы по идентификационному номеру заказа
     * @param id идентификационный номер заказа
     */
    public void removeById(int id) {
        store.removeById(id);
    }

    /**
     * Метод возвращает общую себестоимость списка заказов
     * @param orderList список заказов
     * @return себестоимость
     */
    public double getTotalCost(List<Order> orderList) {
        return getTotalByFunction(orderList, Order::getOrderCost);
    }

    /**
     *Метод возвращает общую цену списка заказов
     *@param orderList список заказов
     *@return цена
     */
    public double getTotalPrice(List<Order> orderList) {
        return getTotalByFunction(orderList, Order::getOrderPrice);
    }

    /**
     *Метод возвращает общую прибыль списка заказов
     *@param orderList список заказов
     *@return прибыль
     */
    public double getTotalProfit(List<Order> orderList) {
        return getTotalByFunction(orderList,
                order -> order.getOrderPrice() - order.getOrderCost());
    }

    /**
     * Метод для расчета складывает соответствующие характеристики заказа
     * @param orders список заказов
     * @param function функция расчета
     * @return результат расчета
     */
    private double getTotalByFunction(List<Order> orders, ToDoubleFunction<Order> function) {
        double sum = 0.0;
        for (Order order : orders) {
            sum += function.applyAsDouble(order);
        }
        return sum;
    }
}
