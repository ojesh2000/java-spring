package com.app.aopdemo.exception;

public class CustomException extends Exception{
    public CustomException(){}

    public CustomException(String message){
        super(message);
    }
}
