package com.example.tprestformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleNotFoundUser(BookNotFoundException bookNotFoundException)
    {
        return new ResponseEntity<String>(bookNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }
}

