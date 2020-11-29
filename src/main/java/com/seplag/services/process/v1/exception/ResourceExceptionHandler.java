package com.seplag.services.process.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NullObjectException.class)
    public ResponseEntity<StandardError> nullObjectException(NullObjectException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                getStandardError(request, HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(NullParameterException.class)
    public ResponseEntity<StandardError> nullParameterException(NullParameterException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                getStandardError(request, HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentExceptionException(IllegalArgumentException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                getStandardError(request, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                getStandardError(request, HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(DuplicateKeyInsertionParameterException.class)
    public ResponseEntity<StandardError> duplicateKeyInsertionParameterException(DuplicateKeyInsertionParameterException e,
                                                               HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                getStandardError(request, HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    private StandardError getStandardError(HttpServletRequest request, HttpStatus unauthorized, String message) {
        return new StandardError(System.currentTimeMillis(), unauthorized.value(),
                unauthorized.getReasonPhrase(), message, request.getRequestURI());
    }
}
