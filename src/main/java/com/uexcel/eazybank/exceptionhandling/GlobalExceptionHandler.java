package com.uexcel.eazybank.exceptionhandling;

import com.uexcel.eazybank.dto.ErrorResponseDto;
import com.uexcel.eazybank.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppExceptionHandler.class)
    public ResponseEntity<ErrorResponseDto>
    handleAppExceptionHandler(AppExceptionHandler e, WebRequest request) {
       return ResponseEntity.status(e.getStatus()).body(
                new ErrorResponseDto(
                        ICustomerService.getTime(),e.getStatus(),
                        HttpStatus.resolve(e.getStatus()), e.getMessage(),
                                request.getDescription(false)
                )
        );
    }
}
