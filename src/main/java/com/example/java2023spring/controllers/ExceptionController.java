package com.example.java2023spring.controllers;

import com.example.java2023spring.dto.ErrorDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> handleError(MethodArgumentNotValidException exception, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDto.builder()
                        .messages(exception.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
                        .build());
    }

    @ExceptionHandler({IOException.class})
    public ResponseEntity<ErrorDto> handleError(IOException exception, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDto.builder()
                        .messages(Arrays.asList(exception.getMessage()))
                        .build());
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorDto> handleError(NoSuchElementException exception, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDto.builder()
                        .messages(Arrays.asList("Not Found!"))
                        .build());
    }
}
