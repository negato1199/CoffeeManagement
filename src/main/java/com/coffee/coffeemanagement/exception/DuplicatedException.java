package com.coffee.coffeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicatedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private String errorMessage;

    public DuplicatedException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public DuplicatedException() {
    }
}
