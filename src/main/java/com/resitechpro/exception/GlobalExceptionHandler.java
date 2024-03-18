package com.resitechpro.exception;


import com.resitechpro.exception.customexceptions.ValidationException;
import com.resitechpro.utils.Response;
import com.resitechpro.utils.ErrorMessage;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<List<ErrorMessage>>> inputValidationException(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errorMessages = new ArrayList<>();
        Response<List<ErrorMessage>> response = new Response<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            String errorField = error.getField();
            ErrorMessage errorMessageObj = ErrorMessage.builder()
                    .field(errorField)
                    .message(errorMessage).build();
            errorMessages.add(errorMessageObj);
        });
        response.setMessage("Validation error");
        response.setErrors(errorMessages);
        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<ErrorMessage>> inputValidationException(ValidationException ex) {
        Response<ErrorMessage> response = new Response<>();
        response.setMessage("Validation error");
        response.setErrors(ex.getErrors());
        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({
        BadRequestException.class,
        Exception.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<String>> abstractBadRequest(Exception ex) {
        Response<String> response = new Response<>();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({
            InvalidDataAccessResourceUsageException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response<String>> notFoundTenant(InvalidDataAccessResourceUsageException ex) {
        Response<String> response = new Response<>();
        response.setMessage("Organization Not found ");
        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

}
