package com.example.springboot.exceptions;

public class ApiRequestException extends  RuntimeException{

    public ApiRequestException(String message){
        super(message);
    }

}
