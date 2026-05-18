package com.example.locacao_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApoliceNaoEncontradoException extends RuntimeException {
    public ApoliceNaoEncontradoException(String message) {
        super(message);
    }
}
