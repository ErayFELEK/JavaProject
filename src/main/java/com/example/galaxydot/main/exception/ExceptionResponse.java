package com.example.galaxydot.main.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExceptionResponse {

    private final String message;

    private final Throwable throwable;

    private final HttpStatus httpStatus;

    private final LocalDateTime time;

}
