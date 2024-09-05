package com.ecommerce.digital.adapter.input.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // com essa anotaçao toda exceção é capturada e o erro é lançado de uma única maneira. Isso ajuda a manter o código de tratamento de exceções separado da lógica dos controladores
public class RestExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class) // lida de forma personalizada com as exceções dos controllers
    public ResponseEntity<Map<String, String>> validationHandler(MethodArgumentNotValidException ex) {
        Map errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }); //
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
