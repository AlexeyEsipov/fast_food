package ru.job4j.v1.model.mappers;

import org.mapstruct.Mapper;
import ru.job4j.v1.model.DishDto;
import ru.job4j.v1.model.entity.Dish;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishDto toDto(Dish dish);
    List<DishDto> toDto(List<Dish> dishes);
}