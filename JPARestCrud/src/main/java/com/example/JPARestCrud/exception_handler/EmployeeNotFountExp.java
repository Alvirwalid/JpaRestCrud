package com.example.JPARestCrud.exception_handler;

public class EmployeeNotFountExp extends  RuntimeException{
    public EmployeeNotFountExp(String message) {
        super(message);
    }

    public EmployeeNotFountExp(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFountExp(Throwable cause) {
        super(cause);
    }
}
