package com.jpa.demo.cruddemo.global_exception_handler;

import com.jpa.demo.cruddemo.error.EmployeeNotFoundErrorResponse;
import com.jpa.demo.cruddemo.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler
    public ResponseEntity<EmployeeNotFoundErrorResponse> handleNoEmployeeFound(EmployeeNotFoundException ex){
        return new ResponseEntity<>(new EmployeeNotFoundErrorResponse(ex.getMessage(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.name()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
