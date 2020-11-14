package com.kutayyaman.issuemanagement.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class IssueManagementExceptionHandler {

    @ExceptionHandler(Exception.class) //butun exceptionlari yakalicak bunu ozellestirilmis hallerini yazabiliriz.
    public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
