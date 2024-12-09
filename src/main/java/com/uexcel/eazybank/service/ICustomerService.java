package com.uexcel.eazybank.service;

import com.uexcel.eazybank.dto.CustomerDto;
import com.uexcel.eazybank.dto.ResponseDto;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface ICustomerService {
    ResponseDto addCustomer(CustomerDto customerDto);

    default String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}
