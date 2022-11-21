package admin.service;

import domain.model.Courier;
import domain.model.Dish;

public interface AdminService {
    Dish createDishForMenu(String name, double cost, double price);
    Courier createCourier(String name);
}
