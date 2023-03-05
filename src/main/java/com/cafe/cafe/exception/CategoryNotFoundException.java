package com.cafe.cafe.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long id) { super(String.format("Category with id [%s] is not found", id)); }
}
