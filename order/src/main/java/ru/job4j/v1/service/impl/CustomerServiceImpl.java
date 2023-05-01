package ru.job4j.v1.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.v1.model.entity.Customer;
import ru.job4j.v1.model.status.CustomerStatus;
import ru.job4j.v1.repository.CustomerRepository;
import ru.job4j.v1.service.CustomerService;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final String NOT_FOUND = "This CustomerId was not found: ";
    private final CustomerRepository repository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return repository.findAll();
    }

    @Override
    public boolean isExistById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Customer findCustomerById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "%s%s".formatted(NOT_FOUND, id)));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer setStatus(Customer customer, CustomerStatus status) {
        if (!repository.existsById(customer.getId())) {
            throw new IllegalArgumentException(
                    "%s%s".formatted(NOT_FOUND, customer.getId()));
        }
        customer.setStatus(status);
        return repository.save(customer);
    }

    @Override
    public CustomerStatus getStatusById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "%s%s".formatted(NOT_FOUND, id))).getStatus();
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        repository.deleteById(customer.getId());
        return !repository.existsById(customer.getId());
    }
}
