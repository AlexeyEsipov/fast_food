package ru.job4j.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.v1.model.DishDto;
import ru.job4j.v1.model.entity.Card;
import ru.job4j.v1.model.entity.Dish;
import ru.job4j.v1.model.entity.Order;
import ru.job4j.v1.model.mappers.DishMapper;
import ru.job4j.v1.model.status.OrderStatus;
import ru.job4j.v1.service.CardService;
import ru.job4j.v1.service.MenuService;
import ru.job4j.v1.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/manager",
        produces = "application/json")
@Tag(
        name = "Менеджер",
        description = "Все методы для работы менеджера системы"
)
@AllArgsConstructor
public class ManagerController {
    private final MenuService menuService;
    private final OrderService orderService;
    private final DishMapper dishMapper;
    private final CardService cardService;

    @PostMapping("/adddish")
    @Operation(summary = "Добавить блюдо в меню")
    /* {
    "id": 1,
    "name": "food1",
    "price": 1.12,
    "status": "AVAILABLE"
}*/
    public ResponseEntity<DishDto> addDish(@RequestBody Dish dish) {
        /*Dish dish = Dish.builder()
                .id(0)
                .name("food1")
                .price(1.12)
                .status(MenuStatus.AVAILABLE)
                .build();*/
        return new ResponseEntity<>(dishMapper.toDto(menuService.create(dish)), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @Operation(summary = "Список блюд с любым статусом")
    public ResponseEntity<List<Dish>> getAllMenu() {
        List<Dish> menu = menuService.getAll();
        if (menu.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "Удалить блюдо")
    public void deleteProductById(@Parameter(description = "id блюда")@PathVariable("productId") int id) {
        menuService.deleteById(id);
    }

    @GetMapping("/cards")
    @Operation(summary = "Список всех карт в системе")
    public ResponseEntity<List<Card>> getCards() {
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/orders")
    @Operation(summary = "Список всех заказов")
    public ResponseEntity<List<Order>> allOrders() {
        return new ResponseEntity<>(orderService.findAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/finished")
    @Operation(summary = "Список всех выполненных заказов")
    public ResponseEntity<List<Order>> allFinishedOrders() {
        return new ResponseEntity<>(orderService.findOrdersByStatus(OrderStatus.FINISHED), HttpStatus.OK);
    }

    @GetMapping("/ready")
    @Operation(summary = "Список всех готовых заказов")
    public ResponseEntity<List<Order>> allReadyOrders() {
        return new ResponseEntity<>(orderService.findOrdersByStatus(OrderStatus.READY), HttpStatus.OK);
    }
}
