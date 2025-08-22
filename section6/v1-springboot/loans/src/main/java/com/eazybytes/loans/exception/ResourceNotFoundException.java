package com.eazybytes.loans.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String loan, String mobileNumber, String mobileNumber1) {
        super(String.format("%s not found with the given  %s : '%s'",loan,mobileNumber,mobileNumber1));
    }
}
