package com.pleo.exception;

public class InvalidCellHeightsException extends RuntimeException {

    private String message;

    public InvalidCellHeightsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
