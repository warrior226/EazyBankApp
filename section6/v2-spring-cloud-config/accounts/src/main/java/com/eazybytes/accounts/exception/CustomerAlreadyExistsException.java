package com.eazybytes.accounts.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This annotation marks an exception as a Spring response status.
// It is used to handle exceptions in a RESTful way.
// The value of the annotation is the HTTP status that should be returned to the client.
// In this case, we are returning a 400 (Bad Request) status.
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
