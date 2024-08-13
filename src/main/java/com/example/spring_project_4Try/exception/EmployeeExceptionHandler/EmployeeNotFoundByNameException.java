package com.example.spring_project_4Try.exception.EmployeeExceptionHandler;

public class EmployeeNotFoundByNameException extends RuntimeException {

    public String name;

    public EmployeeNotFoundByNameException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return name;
    }
}
