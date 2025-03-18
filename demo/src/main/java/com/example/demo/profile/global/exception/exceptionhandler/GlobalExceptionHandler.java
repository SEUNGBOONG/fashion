package com.example.demo.profile.global.exception.exceptionhandler;

import com.example.demo.profile.global.exception.exceptionhandler.dto.ErrorResponse;
import com.example.demo.profile.global.exception.exceptions.CustomErrorCode;
import com.example.demo.profile.global.exception.exceptions.CustomException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleException(CustomException e) {
        CustomErrorCode customErrorCode = e.getCustomErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(customErrorCode.getCustomCode(), customErrorCode.getMessage());
        return ResponseEntity.status(customErrorCode.getHttpStatus()).body(errorResponse);
    }
}
