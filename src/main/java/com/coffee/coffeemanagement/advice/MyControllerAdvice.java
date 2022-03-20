package com.coffee.coffeemanagement.advice;

import com.coffee.coffeemanagement.exception.DuplicatedException;
import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.exception.UnauthorizedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("Input field is empty, please look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<String> handleDuplicated(DuplicatedException duplicatedException) {
        return new ResponseEntity<String>(duplicatedException.getErrorMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity<String>(resourceNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorized(UnauthorizedException unauthorizedException) {
        return new ResponseEntity<String>(unauthorizedException.getErrorMessage(), HttpStatus.UNAUTHORIZED);
    }
}
