package com.vpp97.tripsrestapi.api.controllers.error_handlers;


import com.vpp97.tripsrestapi.dtos.responses.ErrorResponse;
import com.vpp97.tripsrestapi.dtos.responses.FieldErrorsResponse;
import com.vpp97.tripsrestapi.exceptions.RequestParamsInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldErrorsResponse> handleValidationExceptions(
            MethodArgumentNotValidException exception) {

        String message = "Some fields of your payload are invalid";
        Map<String, String> fieldErrors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        FieldErrorsResponse errorsResponse = FieldErrorsResponse.builder()
                .fieldsErrors(fieldErrors)
                .message(message)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RequestParamsInvalidException.class)
    public ResponseEntity<ErrorResponse> handleRequestParamsException(RequestParamsInvalidException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Request params error")
                .detail(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }
}
