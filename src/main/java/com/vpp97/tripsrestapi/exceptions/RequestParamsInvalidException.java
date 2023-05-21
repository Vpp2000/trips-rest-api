package com.vpp97.tripsrestapi.exceptions;

public class RequestParamsInvalidException extends RuntimeException{
    public RequestParamsInvalidException(String message){
        super(message);
    }
}
