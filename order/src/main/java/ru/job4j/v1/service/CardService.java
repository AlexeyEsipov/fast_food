package ru.job4j.v1.service;


import ru.job4j.v1.model.entity.Card;
import ru.job4j.v1.model.entity.Customer;

import java.util.List;

public interface CardService {
    Card create(Customer customer);
    List<Card> findAll();
    List<Card> findAllByCustomer(Customer customer);
    void delete(Card card);
    void deleteByCustomer(Customer customer);
    void deleteAll();
}
