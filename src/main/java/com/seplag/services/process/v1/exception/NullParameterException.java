package com.seplag.services.process.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class NullParameterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NullParameterException(String message){
        super(message);
    }

}
