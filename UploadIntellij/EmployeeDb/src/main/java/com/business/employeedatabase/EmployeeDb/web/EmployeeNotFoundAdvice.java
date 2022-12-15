package com.business.employeedatabase.EmployeeDb.web;


import com.business.employeedatabase.EmployeeDb.domain.EmployeeNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class EmployeeNotFoundAdvice extends Throwable {


        @ExceptionHandler(EmployeeNotFoundException.class)
        @ResponseStatus(value = HttpStatus.NOT_FOUND)

        public String employeeNotFoundException(EmployeeNotFoundException ex) {

            return ex.getMessage();

    }






}
