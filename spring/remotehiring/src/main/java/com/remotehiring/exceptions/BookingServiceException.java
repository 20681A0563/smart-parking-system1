package com.remotehiring.exceptions;

public class BookingServiceException extends RuntimeException {
    public BookingServiceException(String message) {
        super(message);
    }
}
