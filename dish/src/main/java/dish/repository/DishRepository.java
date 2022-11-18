package dish.repository;

import domain.model.Dish;

import java.util.Collection;
import java.util.Optional;

public interface DishRepository {
    Dish addDish(Dish dish);
    Collection<Dish> findAll();
    Optional<Dish> findById(int id);
    Optional<Dish> findByName(String name);
    void deleteById(int id);
}
