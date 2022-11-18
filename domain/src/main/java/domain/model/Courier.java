package domain.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Класс описывает курьера. Курьер имеет имя {@code name}, статус {@code isBusy} ({@code true} - выполняет задание,
 * {@code false} - свободен и готов к выполнению задания), местоположение {@code position} и список заказов {@code orderList},
 * которые он сейчас выполняет. Соответственно, если курьер свободен ({@code isBusy = false}), то список заказов пустой
 * ({@code orderList.size() = 0})
 * @author Есипов Алексей
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Courier {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private boolean isBusy;
    private String position;
    private List<Order> orderList;

    public Courier(String name) {
        this.name = name;
    }
}
