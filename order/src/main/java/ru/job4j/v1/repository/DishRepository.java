package ru.job4j.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import ru.job4j.v1.model.entity.Dish;
import ru.job4j.v1.model.status.MenuStatus;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    boolean existsByNameIgnoreCaseAndStatus(@NonNull String name, @NonNull MenuStatus status);
    List<Dish> findByStatus(@NonNull MenuStatus status);
    Set<Dish> findByNameInIgnoreCaseAndStatus(@NonNull Collection<String> names, @NonNull MenuStatus status);
    long deleteByNameIgnoreCase(@NonNull String name);
    Optional<Dish> findByNameIgnoreCase(@NonNull String name);


}