package com.assignment.eventmanagement.demo.exception;

import com.assignment.eventmanagement.demo.Error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(
            BadRequestException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Bad Request",details);
        return new ResponseEntity<>(apiError,  HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(
            value = HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(
            ResourceNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Resource Not Found",details);
        return new ResponseEntity<>(apiError,  HttpStatus.NOT_FOUND);
    }

}
