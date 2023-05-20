package com.vpp97.tripsrestapi.controllers.error_handlers;

import com.vpp97.tripsrestapi.dtos.responses.ErrorResponse;
import com.vpp97.tripsrestapi.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundControllerAdvice {
    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleIfIdNotFound(IdNotFoundException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Id not found")
                .detail(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
