package com.cafe.cafe.service.exception;

public class EntityCannotBeDeletedException extends RuntimeException{
    public EntityCannotBeDeletedException(String message) {
        super(message);
    }
}
