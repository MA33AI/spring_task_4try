package com.example.spring_project_4Try.exception.EmployeeExceptionHandler;

import java.util.UUID;

public class EmployeeNotFoundByIdException extends RuntimeException {

    public UUID employeeid;

    public EmployeeNotFoundByIdException(UUID employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public String getMessage() {
        return employeeid.toString();
    }
}
