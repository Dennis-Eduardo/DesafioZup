package com.desafio.zup.handler;

import com.desafio.zup.exception.ComicNotFoundException;
import com.desafio.zup.exception.EntityNotFoundException;
import com.desafio.zup.exception.UserNotFoundException;
import com.desafio.zup.error.HttpError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;


@ControllerAdvice
public class SpringValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        System.out.println(errors);
        HttpError httpError = new HttpError(status, "", errors);
        return new ResponseEntity<>(httpError, headers, status);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(EntityNotFoundException ex, WebRequest request){
        HttpError httpError = new HttpError(ex.getHttpStatus(), ex.getMessage());
        return new ResponseEntity<>(httpError,  ex.getHttpStatus());
    }
    @ExceptionHandler(ComicNotFoundException.class)
    public ResponseEntity<Object> handleComicNotFound(EntityNotFoundException ex, WebRequest request){
        HttpError httpError = new HttpError(ex.getHttpStatus(), ex.getMessage());
        return new ResponseEntity<>(httpError,  ex.getHttpStatus());
    }

}