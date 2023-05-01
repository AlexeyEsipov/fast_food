package ru.job4j.v1.model.mappers;

import org.mapstruct.Mapper;
import ru.job4j.v1.model.CustomerDto;
import ru.job4j.v1.model.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}