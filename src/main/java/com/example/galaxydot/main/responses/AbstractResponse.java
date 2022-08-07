package com.example.galaxydot.main.responses;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AbstractResponse<T> {

    private T data;

    private HttpStatus status;

}
