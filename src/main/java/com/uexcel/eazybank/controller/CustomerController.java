package com.uexcel.eazybank.controller;

import com.uexcel.eazybank.dto.CustomerDto;
import com.uexcel.eazybank.dto.ResponseDto;
import com.uexcel.eazybank.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @PostMapping("/api/register")
    public ResponseEntity<ResponseDto> addCustomer(@RequestBody CustomerDto customerDto) {
        ResponseDto rs = customerService.addCustomer(customerDto);
        return ResponseEntity.status(rs.getStatus()).body(rs);
    }
}
