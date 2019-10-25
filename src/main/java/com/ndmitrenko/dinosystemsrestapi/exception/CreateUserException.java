package com.ndmitrenko.dinosystemsrestapi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserException extends RuntimeException{

    private HttpStatus code;
    private ApiResult apiResult;

    public CreateUserException(HttpStatus code, String message) {
        super(message);
        this.code = code;
        this.apiResult = ApiResult.FAIL;
    }

    public CreateUserException(String message) {
        super(message);
        this.apiResult = ApiResult.FAIL;
    }
}
