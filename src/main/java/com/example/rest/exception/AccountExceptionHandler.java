package com.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


    @RestControllerAdvice
    public class AccountExceptionHandler {

        @ExceptionHandler(AccountNotFoundException.class)
        public ResponseEntity<AccountException> handleCloudVendorNotFoundException(AccountNotFoundException ex) {

            AccountException errorResponse = new AccountException(LocalDateTime.now(), "ACC_001", ex.getMessage());

            return new ResponseEntity<>(
                    errorResponse,
                    HttpStatus.NOT_FOUND);
        }
    }

