package com.jpa.demo.cruddemo.entity;

import org.springframework.http.HttpStatus;

public class StudentErrorResponse  {
    private String message;
    private String status;
    private String description;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StudentErrorResponse(){
    }

    public StudentErrorResponse(String message, String status, String description){
        this.message = message;
        this.status = status;
        this.description = description;
    }
}
