package com.vh.springquickstart.configuration.exception;

import com.vh.springquickstart.core.domain.ApiSecurityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsConfig {


    @ExceptionHandler(ApiSecurityException.class)
    public ResponseEntity handleApiSecurityException(ApiSecurityException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ApiException apiException = new ApiException(e.getMessage(), 403);
        return ResponseEntity.status(status).body(apiException);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException apiException = new ApiException(e.getMessage(), 500);
        return ResponseEntity.status(status).body(apiException);
    }

}
