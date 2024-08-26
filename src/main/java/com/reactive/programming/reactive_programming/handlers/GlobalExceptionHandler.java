package com.reactive.programming.reactive_programming.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public Mono<ResponseEntity<String>> handlerNotFoundException(NotFoundException ex){
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()));
    }
}
