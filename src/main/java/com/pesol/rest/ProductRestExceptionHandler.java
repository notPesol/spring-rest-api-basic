package com.pesol.rest;

import com.pesol.rest.model.MyErrorBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ProductRestExceptionHandler {

    // exception handler for NumberFormatException
    @ExceptionHandler
    public ResponseEntity<MyErrorBody> numberFormatExceptionHandler(ProductNotFoundException e,
                                                                    HttpServletRequest request) {
        MyErrorBody body = new MyErrorBody(
                HttpStatus.NOT_FOUND.value(),
                e.getClass().getSimpleName(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // exception handler for all
    @ExceptionHandler
    public ResponseEntity<MyErrorBody> exceptionHandler(Exception e,
                                                                    HttpServletRequest request) {
        MyErrorBody body = new MyErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                e.getClass().getSimpleName(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
