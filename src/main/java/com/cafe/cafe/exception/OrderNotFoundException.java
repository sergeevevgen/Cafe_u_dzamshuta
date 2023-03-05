package com.cafe.cafe.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) { super(String.format("Order with id [%s] is not found", id)); }
}
