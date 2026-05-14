package com.example.locacao_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PagamentoNaoEncontradoException extends RuntimeException {
    public PagamentoNaoEncontradoException(String message) {
        super(message);
    }
}
