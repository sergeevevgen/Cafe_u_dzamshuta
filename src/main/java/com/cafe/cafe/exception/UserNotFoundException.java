package com.cafe.cafe.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) { super(String.format("User with id [%s] is not found", id)); }
}
