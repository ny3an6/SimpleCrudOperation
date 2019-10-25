package com.ndmitrenko.dinosystemsrestapi.dto.response.exception;

import com.ndmitrenko.dinosystemsrestapi.exception.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class DefaultExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
    private ApiResult apiResult;
}
