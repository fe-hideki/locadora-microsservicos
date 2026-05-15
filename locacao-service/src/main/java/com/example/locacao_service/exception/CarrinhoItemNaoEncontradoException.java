package com.example.locacao_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CarrinhoItemNaoEncontradoException extends RuntimeException {
    public CarrinhoItemNaoEncontradoException(String message) {
        super(message);
    }
}
