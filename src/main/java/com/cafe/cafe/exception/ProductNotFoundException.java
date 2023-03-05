package com.cafe.cafe.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) { super(String.format("Product with id [%s] is not found", id)); }
}
