package com.ht.business;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Angel Segoviano 3/28/2021 RestControllerExceptionAdvice
 */

@RestControllerAdvice
public class RestControllerExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>handleException(Exception ex) {
        return new ResponseEntity<String>("An Error has occured, Try Again.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
