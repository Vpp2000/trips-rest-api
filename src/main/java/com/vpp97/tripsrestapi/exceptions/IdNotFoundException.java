package com.vpp97.tripsrestapi.exceptions;

public class IdNotFoundException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Record with id %s doesnt exist in document %s";

    public IdNotFoundException(String id, String collectionName){
        super(String.format(ERROR_MESSAGE, id, collectionName));
    }
}
