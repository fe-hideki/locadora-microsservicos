package com.example.veiculo_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public Map<String, String> handleNotFound(RuntimeException ex) {
            return Map.of("erro", ex.getMessage());
        }

        @ExceptionHandler(IllegalArgumentException.class)
        @ResponseStatus(HttpStatus.CONFLICT)
        public Map<String, String> handleConflict(IllegalArgumentException ex) {
            return Map.of("erro", ex.getMessage());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
            Map<String, String> erros = new LinkedHashMap<>();
            ex.getBindingResult().getFieldErrors()
                    .forEach(e -> erros.put(e.getField(), e.getDefaultMessage()));
            return erros;
        }

}
