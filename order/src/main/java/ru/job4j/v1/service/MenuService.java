package ru.job4j.v1.service;


import ru.job4j.v1.model.entity.Dish;
import ru.job4j.v1.model.status.MenuStatus;

import java.util.List;
import java.util.Set;

public interface MenuService {
    List<Dish> getAll();
    Dish create(Dish dish);
    Dish findById(int id);
    Dish findByName(String name);
    boolean isAvailableByName(String name);
    List<Dish> findByStatus(MenuStatus status);
    Set<Dish> findSetNames(Set<String> listNames);
    void deleteById(int id);
    void deleteByName(String name);
}
