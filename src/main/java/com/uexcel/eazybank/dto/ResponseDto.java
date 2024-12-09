package com.uexcel.eazybank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ResponseDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timestamp;
    private int status;
    private HttpStatus description;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String apiPath;

}
