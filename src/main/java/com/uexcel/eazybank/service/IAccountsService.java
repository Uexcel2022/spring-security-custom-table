package com.uexcel.eazybank.service;

import com.uexcel.eazybank.dto.AccountsDto;

import java.util.List;

public interface IAccountsService {
    List<AccountsDto> fetchAccountsByCustomerIdOrAccountNumber(Long customerId, Long accountNumber);
}
