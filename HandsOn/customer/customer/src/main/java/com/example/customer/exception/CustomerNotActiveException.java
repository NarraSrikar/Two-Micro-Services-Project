package com.example.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CustomerNotActiveException extends RuntimeException{
    public CustomerNotActiveException(String message) {
        super(message);
    }
}
