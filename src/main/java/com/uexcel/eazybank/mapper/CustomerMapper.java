package com.uexcel.eazybank.mapper;

import com.uexcel.eazybank.dto.CustomerDto;
import com.uexcel.eazybank.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(Customer customer, CustomerDto customerDto) {
        customer.setPwd(customerDto.getPwd());
        customer.setEmail(customerDto.getEmail());
        customer.setRole(customerDto.getRole());
        return customer;
    }
}
