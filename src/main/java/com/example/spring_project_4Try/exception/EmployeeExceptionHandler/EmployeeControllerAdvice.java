package com.example.spring_project_4Try.exception.EmployeeExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundByIdException.class)
    public ResponseEntity<String> handleIdNotFoundException(Exception ex) {
        return new ResponseEntity<>(String.format("Employee not found by id - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundByNameException.class)
    public ResponseEntity<String> handleNameNotFoundException(Exception ex) {
        return new ResponseEntity<>(String.format("Employee not found by name - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
