package ru.job4j.v1.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.v1.model.entity.Dish;
import ru.job4j.v1.model.status.MenuStatus;
import ru.job4j.v1.repository.DishRepository;
import ru.job4j.v1.service.MenuService;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final DishRepository dishRepository;

    @Override
    public List<Dish> getAll() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish findById(int id) {
        return dishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "This Dish ID was not found: %s".formatted(id)));
    }

    @Override
    public Dish findByName(String name) {
        return dishRepository.findByNameIgnoreCase(name).orElseThrow(() -> new IllegalArgumentException(
                "This Dish Name was not found: %s".formatted(name)));
    }

    @Override
    public boolean isAvailableByName(String name) {
        return dishRepository.existsByNameIgnoreCaseAndStatus(name, MenuStatus.AVAILABLE);
    }

    @Override
    public List<Dish> findByStatus(MenuStatus status) {
        return dishRepository.findByStatus(status);
    }

    @Override
    public Set<Dish> findSetNames(Set<String> setNames) {
        return dishRepository.findByNameInIgnoreCaseAndStatus(setNames, MenuStatus.AVAILABLE);
    }

    @Override
    public void deleteById(int id) {
        dishRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        dishRepository.deleteByNameIgnoreCase(name);
    }
}
