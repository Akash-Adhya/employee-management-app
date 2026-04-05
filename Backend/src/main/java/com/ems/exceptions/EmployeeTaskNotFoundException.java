package com.ems.exceptions;

public class EmployeeTaskNotFoundException extends RuntimeException {
    public EmployeeTaskNotFoundException(String message){
        super(message);
    }
}
