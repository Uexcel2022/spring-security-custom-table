package com.uexcel.eazybank.mapper;

import com.uexcel.eazybank.dto.LoanDto;
import com.uexcel.eazybank.model.Loans;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public LoanDto mapToLoanDto(Loans loans,LoanDto loanDto){
        loanDto.setId(loans.getLoanNumber());
        loanDto.setLoanType(loans.getLoanType());
        loanDto.setTotalLoan(loans.getTotalLoan());
        loanDto.setAmountPaid(loans.getAmountPaid());
        loanDto.setOutstandingAmount(loans.getOutstandingAmount());
        loanDto.setCreateDt(loans.getCreateDt());
        loanDto.setStartDt(loans.getStartDt());
        loanDto.setAccountNumber(loans.getAccounts().getAccountNumber());
        return loanDto;
    }
}
