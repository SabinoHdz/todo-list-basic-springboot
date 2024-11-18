package com.springboot.todolistbasic.todolist_basic.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.springboot.todolistbasic.todolist_basic.exceptions.TaskNotFoundException;
import com.springboot.todolistbasic.todolist_basic.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("API Not Found");
        error.setTimestamp(new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({ TaskNotFoundException.class,
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 400
    public ResponseEntity<Error> notFoundDataException(Exception e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError("Task not found or data is not available");
        error.setTimestamp(new Date());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
