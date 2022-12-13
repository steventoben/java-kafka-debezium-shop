package com.example.catalogservice.exception;

import java.io.Serial;

public class ProductDoesNotExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
