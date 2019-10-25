package com.ndmitrenko.dinosystemsrestapi.exception.controller;

import com.ndmitrenko.dinosystemsrestapi.dto.response.exception.DefaultExceptionResponse;
import com.ndmitrenko.dinosystemsrestapi.exception.CreateUserException;
import com.ndmitrenko.dinosystemsrestapi.exception.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<Object> handleProblemWithShowingCompany(DefaultException ex) {
        return new ResponseEntity<>(new DefaultExceptionResponse(ex.getCode(),ex.getMessage() ,ex.getApiResult()), HttpStatus.NOT_FOUND);
    }
}
