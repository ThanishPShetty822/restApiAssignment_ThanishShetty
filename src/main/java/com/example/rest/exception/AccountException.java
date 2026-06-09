package com.example.rest.exception;

import java.time.LocalDateTime;

public class AccountException {

    private final LocalDateTime timestamp;
    private final String errorCode;
    private final String message;

    public AccountException(
            LocalDateTime timestamp,
            String errorCode,
            String message) {

        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}