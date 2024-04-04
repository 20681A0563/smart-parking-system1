package com.remotehiring.exceptions;

public class CustomMailException extends RuntimeException {

    public CustomMailException(String message) {
        super(message);
    }

    public CustomMailException(String message, Throwable cause) {
        super(message, cause);
    }
}
