package com.jpa.demo.cruddemo.globalExceptionHandler;

import com.jpa.demo.cruddemo.entity.StudentErrorResponse;
import com.jpa.demo.cruddemo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> handleStudentNotFoundEx(StudentNotFoundException ex){
        return new ResponseEntity<>(new StudentErrorResponse(ex.getMessage(),HttpStatus.OK.name(), "Student Not Found") , HttpStatus.NOT_FOUND);
    }
}
