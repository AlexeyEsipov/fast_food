package order.service;

import domain.model.Order;

import java.util.Collection;
import java.util.List;

public interface OrderService {
    /**
     * Метод добавляет новый заказ в базу заказов
     * @param order заказ
     * @return заказ
     */
    Order save(Order order);

    /**
     * Метод возвращает все заказы в виде коллекции
     * @return коллекция
     */
    Collection<Order> findAll();

    /**
     * Метод возвращает коллекцию всех выполненных заказов
     * @return коллекция
     */
    Collection<Order> findAllCompleted();

    /**
     * Метод возвращает коллекцию всех текущих невыполненных заказов
     * @return коллекция
     */
    Collection<Order> findAllNotCompleted();

    /**
     * Метод ищет конкретный заказ по его идентификационному номеру
     * @param id идентификационный номер
     * @return заказ
     */
    Order findById(int id);

    /**
     * Метод ищет все заказы по идентификационному номеру заказчика
     * @param id идентификационный номер заказчика
     * @return заказ
     */
    Collection<Order> findByUserId(int id);

    /**
     * Метод удаляет заказ из базы по идентификационному номеру заказа
     * @param id идентификационный номер заказа
     */
    void removeById(int id);

    /**
     * Метод возвращает общую себестоимость списка заказов
     * @param orderList список заказов
     * @return себестоимость
     */
    double getTotalCost(List<Order> orderList);

    /**
     *Метод возвращает общую цену списка заказов
     *@param orderList список заказов
     *@return цена
     */
    double getTotalPrice(List<Order> orderList);

    /**
     *Метод возвращает общую прибыль списка заказов
     *@param orderList список заказов
     *@return прибыль
     */
    double getTotalProfit(List<Order> orderList);
}
