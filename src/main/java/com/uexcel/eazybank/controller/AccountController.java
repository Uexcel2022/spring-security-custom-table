package com.uexcel.eazybank.controller;

import com.uexcel.eazybank.dto.AccountsDto;
import com.uexcel.eazybank.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    private final  IAccountsService accountsService;
    @GetMapping("/myAccounts")
    public ResponseEntity<AccountsDto> getAccountDetails(@RequestParam Long accountNumber) {
       AccountsDto accountsDto = accountsService
               .fetchAccountsByCustomerIdOrAccountNumber(null,accountNumber).get(0);
        return ResponseEntity.ok(accountsDto);
    }
}
