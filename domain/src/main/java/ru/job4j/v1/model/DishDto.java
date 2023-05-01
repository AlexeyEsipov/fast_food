package ru.job4j.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "Информация о блюде")
@Data
public class DishDto {
    @Schema(description = "Наименование")
    private String name;
    @Schema(description = "Цена")
    private double price;
}
