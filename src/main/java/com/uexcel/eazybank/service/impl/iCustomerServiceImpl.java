package com.uexcel.eazybank.service.impl;

import com.uexcel.eazybank.dto.CustomerDto;
import com.uexcel.eazybank.dto.ResponseDto;
import com.uexcel.eazybank.mapper.CustomerMapper;
import com.uexcel.eazybank.model.Customer;
import com.uexcel.eazybank.repository.CustomerRepository;
import com.uexcel.eazybank.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class iCustomerServiceImpl implements ICustomerService {
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private CustomerRepository customerRepository;
    private CompromisedPasswordChecker cPC;
    @Override
    public ResponseDto addCustomer(CustomerDto customerDto) {
        if(cPC.check(customerDto.getPwd()).isCompromised()){
            return new ResponseDto(
                    getTime(),417,
                    HttpStatus.EXPECTATION_FAILED,"Password is compromised.",null);
        }
        customerDto.setPwd(passwordEncoder.encode(customerDto.getPwd()));
        Customer customer = customerRepository
                .save(customerMapper.toCustomer(new Customer(), customerDto));

        return customer.getId() > 0? new ResponseDto(null,201,
                HttpStatus.CREATED,"Customer registered successfully.",null):
        new ResponseDto(
                getTime(),417,
                HttpStatus.EXPECTATION_FAILED,"Registration failed.",null);
    }
}
