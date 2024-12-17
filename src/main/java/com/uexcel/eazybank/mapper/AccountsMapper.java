package com.uexcel.eazybank.mapper;

import com.uexcel.eazybank.dto.AccountsDto;
import com.uexcel.eazybank.model.Accounts;
import org.springframework.stereotype.Component;

@Component
public class AccountsMapper {
    public AccountsDto mapToDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        accountsDto.setCreateDt(accounts.getCreateDt());
        return accountsDto;

    }
}
