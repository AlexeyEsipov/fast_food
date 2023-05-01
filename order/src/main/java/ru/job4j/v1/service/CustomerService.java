package ru.job4j.v1.service;


import ru.job4j.v1.model.entity.Customer;
import ru.job4j.v1.model.status.CustomerStatus;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    List<Customer> findAllCustomer();
    boolean isExistById(int id);
    Customer findCustomerById(int id);
    Customer updateCustomer(Customer customer);
    Customer setStatus(Customer customer, CustomerStatus status);
    CustomerStatus getStatusById(int id);
    boolean deleteCustomer(Customer customer);
}
