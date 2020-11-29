package com.seplag.services.process.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConstraintViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConstraintViolationException(String message){
        super(message);
    }

}
