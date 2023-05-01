package ru.job4j.v1.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.v1.model.entity.Card;
import ru.job4j.v1.model.entity.Customer;
import ru.job4j.v1.model.status.CardName;
import ru.job4j.v1.repository.CardRepository;
import ru.job4j.v1.service.CardService;

import java.util.List;
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository repository;

    @Override
    public Card create(Customer customer) {
        Card card = new Card();
        card.setCustomerId(customer);
        card.setName(CardName.REGULAR);
        return repository.save(card);
    }

    @Override
    public List<Card> findAll() {
        return (List<Card>) repository.findAll();
    }

    @Override
    public List<Card> findAllByCustomer(Customer customer) {
        return repository.findByCustomerIdId(customer.getId());
    }

    @Override
    public void delete(Card card) {
        repository.delete(card);
    }

    @Override
    public void deleteByCustomer(Customer customer) {
        repository.deleteByCustomerId(customer);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
