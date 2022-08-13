package com.example.galaxydot.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler
        extends ResponseEntityExceptionHandler {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(value = {ErrorException.class})
    protected ResponseEntity<Object> handleConflict(ErrorException ex) {
        var exceptionResponse = ExceptionResponse.builder()
                .httpStatus(badRequest)
                .message(ex.getMessage())
                .time(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionResponse, badRequest);
    }
}
