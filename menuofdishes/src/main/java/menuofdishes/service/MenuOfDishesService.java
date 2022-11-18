package menuofdishes.service;

import domain.model.Dish;

public interface MenuOfDishesService {
    void save(String name, double cost, double price);
    Dish findById(int id);
    Dish findByName(String name);
    void deleteById(int id);
}
