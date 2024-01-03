package com.example.JPARestCrud.exception_handler;


import com.example.JPARestCrud.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

@ExceptionHandler
    public ResponseEntity<EmployeeErrorRes> handleException(EmployeeNotFountExp exp){

        EmployeeErrorRes e=new EmployeeErrorRes();


        e.setStatus(HttpStatus.NOT_FOUND.value());
        e.setMessage(exp.getMessage());
        e.setTimeStemp(String.valueOf(System.currentTimeMillis()));

        return new  ResponseEntity<EmployeeErrorRes>(e,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public  ResponseEntity<EmployeeErrorRes>handleException(Exception exp){
        EmployeeErrorRes e=new EmployeeErrorRes();


        e.setStatus(HttpStatus.BAD_REQUEST.value());
        e.setMessage(exp.getMessage());
        e.setTimeStemp(String.valueOf(System.currentTimeMillis()));

        return  new ResponseEntity<EmployeeErrorRes>(e,HttpStatus.BAD_REQUEST);

    }
}
