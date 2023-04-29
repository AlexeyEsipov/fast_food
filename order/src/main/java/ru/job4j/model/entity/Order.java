package ru.job4j.model.entity;

import lombok.*;
import ru.job4j.model.status.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_db_id")
    private Customer customer;
    @Column(name = "created")
    private Date created;
    @Column(name = "modify")
    private Date modify;
    @ElementCollection
    @CollectionTable(name = "order_products")
    @MapKeyColumn(name = "product_name")
    @Column(name = "quantity")
    private Map<String, Integer> dishes = new HashMap<>();
    @Column(name = "status")
    private OrderStatus orderStatus;
}