package com.jpa.demo.cruddemo.error;

public class EmployeeNotFoundErrorResponse {
    public String message;
    public String description;
    public String statusCode;

    public EmployeeNotFoundErrorResponse(String message, String description, String statusCode) {
        this.message = message;
        this.description = description;
        this.statusCode = statusCode;
    }
}
