package menuofdishes.repository;

import domain.model.Dish;

public interface MenuOfDishesRepository {
    void save(String name, double cost, double price);
    Dish findById(int id);
    Dish findByName(String name);
    void deleteById(int id);
}
